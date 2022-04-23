package com.yp.system.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yp.common.util.JwtTokenUtil;
import com.yp.common.util.PropertiesVO;
import com.yp.common.util.SessionUtil;
import com.yp.common.util.SessionVO;
import com.yp.config.Constants;
import com.yp.config.Constants.LOGGING;
import com.yp.config.Constants.TOKEN_VALIDATE;
import com.yp.config.Startup;
import com.yp.security.model.User;
import com.yp.system.menu.MenuService;
import com.yp.system.menu.MenuVO;
import com.yp.user.UserVO;

public class InterceptorAdapter extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(InterceptorAdapter.class);
	
	@Autowired
	private MenuService menuService;
	
	private PropertiesVO vo = new PropertiesVO();
	
	private String logerYN = vo.getLogerYN();
	
	// Controller 실행전 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		LOGGING queryLogging = Constants.QueryLogging;
    	
    	Constants.QueryLogging = LOGGING.NOLOGGING;
    	Constants.QueryLogging = LOGGING.LOGGING;
	    try {
	    	String url = request.getRequestURI();
	    	if(url.contains("/css/")
	    			|| url.contains("/js/")
	    			|| url.contains("/images/")
	    			|| url.contains(".jpg")
	    			|| url.contains(".png")
	    			|| url.contains(".gif")
	    			|| url.contains(".ico")
	    			){
	    		return true;
	    	}
	    		    	
	    	Enumeration<String> paramsss = request.getParameterNames();
	    	logger.debug("---------- requests @ interceptor ----------");
	    	String params = "";
	    	while (paramsss.hasMoreElements()){
	    		String name = (String)paramsss.nextElement();
	    		params += ( name + "=" + request.getParameter(name) + "&");
	    	}
	    	logger.debug(params);
	    	logger.debug("--------------------------------------------");
	    		    	
	    	//인덱스에서 메뉴조회, 세션유지, index.go 이동, ddcode 공통코드 조회를 제외한 나머지 액션
	    	HttpSession session = request.getSession(true);
    		SessionVO sessionVO = SessionUtil.getSessionVO(session);
    		User user = new User();
			UserVO userVO = new UserVO();
			
			// session검사
			//세션 정보가 존재하는 경우 액션로그 행위자 사번 및 회사코드 존재하면 설정
			if(sessionVO != null) {
				user = SessionUtil.getSessionVO(session).getUser();
				
				userVO.setRole_id(user.getRole_id());
				userVO.setUser_id(user.getUser_id());
				
		    	//토큰 갱신 부분
		    	String access_token = user.getAccess_token();
		    	String refresh_token = user.getRefresh_token();
		    	
		    	JwtTokenUtil jtu = new JwtTokenUtil();
		    	boolean accessTokenValidate = jtu.isTokenExpired(access_token);
		    	
		    	//액세스 토큰 만료 검사가 실패하면
		    	if(!accessTokenValidate) {
		    		//갱신토큰 만료 검사
		    		boolean refreshTokenValidate = jtu.isTokenExpired(refresh_token);
		    		
		    		//갱신토큰이 유효하면 액세스 토큰 재발급
		    		if(refreshTokenValidate) {
		    			int accessTokenTime = Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_MINUTE);
		    			int refreshTokenTime = Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_MINUTE) * Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_HOUR) * Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_DAY);
		    			
		    			access_token = jtu.userRegiToken(user, accessTokenTime);
		    			
		    			//리프레시 토큰 발급 - User에 담긴 정보로 하루짜리 토큰 생성
		    			refresh_token = jtu.userRegiToken(user, refreshTokenTime);
		    			
		    			user.setAccess_token(access_token);
		    			user.setRefresh_token(refresh_token);
		    		}
		    	}
			}
			
			if(url.contains(".go")) {
				MenuVO menuVO = new MenuVO();
				menuVO.setSrch_menu_url(url);
				
				Map<String, Object> menuMap = menuService.getMenuView(menuVO);
				if(menuMap != null) {
					if(url.equals(menuMap.get("menu_url"))) {
						request.setAttribute("menuRole", menuMap);
					}
				} else {
					menuMap = new HashMap<String, Object>();
					menuMap.put("menu_url", url);
					menuMap.put("leftmenu", "N");
					request.setAttribute("menuRole", menuMap);					
				}
			}
			
			request.setAttribute("User", user);
			
	    	/*
	    	//액션 로그
	    	if(exceptionActionLogUrl(url, action_log_yn)) {
				try {
					//액션 로그 생성
					String lower_case_url = url.toLowerCase();
					
					if(lower_case_url.indexOf(".go") > 0) {
						actionLogVO.setAction_type("GO");	//페이지이동
						
					}else if(lower_case_url.indexOf(".pop") > 0) {
						actionLogVO.setAction_type("POPUP");	//팝업이동
						
					}else if(lower_case_url.indexOf(".ajax") > 0) {
						//ajax url 호출 시
						if(lower_case_url.indexOf("get") > 0) {

							if(lower_case_url.indexOf("excel") > 0) {
								actionLogVO.setAction_type("EXCELDOWN");	//엑셀다운로드
								
							} else {
								actionLogVO.setAction_type("READ");		//조회
								
							}
						}else if(lower_case_url.indexOf("insert") > 0) {
							if(lower_case_url.indexOf("insertUploadExcelDataMonth") > 0) {
								actionLogVO.setAction_type("EXCELUPLOAD");	//엑셀업로드
								
							}else if(lower_case_url.indexOf("call") > 0 || lower_case_url.indexOf("copymonth") > 0) {
								actionLogVO.setAction_type("CALL_PROC");	//프로시저 호출
								
							}else {
								actionLogVO.setAction_type("INSERT");		//입력

							}
						}else if(lower_case_url.indexOf("update") > 0) {
							actionLogVO.setAction_type("UPDATE");	//수정
							
						}else if(lower_case_url.indexOf("delete") > 0) {
							actionLogVO.setAction_type("DELETE");	//삭제
							
						}else if(lower_case_url.indexOf("call") > 0 || lower_case_url.indexOf("uploadexcelsavedata") > 0) {
							actionLogVO.setAction_type("CALL_PROC");	//프로시저 호출
						}else {
							actionLogVO.setAction_type("UNKNOWN");
						}
						
					}else if(lower_case_url.indexOf("logout.do") > 0) {
						actionLogVO.setAction_type("LOGOUT");	//로그아웃
						
					}else if(lower_case_url.indexOf("login.do") > 0) {
						actionLogVO.setAction_type("LOGIN");	//로그인
					}else {
						actionLogVO.setAction_type("UNKNOWN");
					}
					
			    	actionLogVO.setAction_url(url);
			    	actionLogVO.setAction_ip(CommUtil.getClientIp(request));
			    	
			    	if(params != null && params.getBytes().length >= 4000) {
			    		//4000바이트 넘어갈 떄 처리, 한글이 3byte여서 1333으로 하려다가 1000으로 진행
			    		actionLogVO.setAction_query_string(params.substring(0, 1000));
			    	}else {
			    		actionLogVO.setAction_query_string(params);
			    	}
		    	
		    		logsService.insertActionLog(actionLogVO);
		    	}catch(Exception e) {
		    		logger.error("액션 로그 기록 중 에러발생");
		    		logger.error(e.getMessage());
		    	}
				
				logger.info("interceptor url=["+url+"]");
				logger.info("회사코드 : " + actionLogVO.getMb_id() + ", 사원번호 : " + actionLogVO.getEmp_cd());
				logger.info("params=["+params+"]");
			}
			*/
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	    
	    Constants.QueryLogging = queryLogging;
        
	    return true;
	}
	
	// Controller 실행후 처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		//운영서버 쿼리로깅 OFF
		if(logerYN.equals("N") || (!Startup.isWindows() && "real".equals(vo.getDBGubun())) ) {
			Constants.QueryLogging = LOGGING.NOLOGGING;
		}else{
			Constants.QueryLogging = LOGGING.LOGGING;
		}
		
	}
	
	// Controller 실행후 View 실행 후 처리
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}
