package com.yp.common;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yp.base.BaseController;
import com.yp.common.util.CommUtil;
import com.yp.common.util.InetUtil;
import com.yp.common.util.JwtTokenUtil;
import com.yp.common.util.SessionUtil;
import com.yp.common.util.SessionVO;
import com.yp.config.Constants;
import com.yp.config.Constants.TOKEN_VALIDATE;
import com.yp.security.model.User;
import com.yp.user.UserVO;

@Controller(value="CommonController")
public class CommonController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/login.go")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("comm/login");
		mv.addObject("mobileCheck", CommUtil.isMobile(request));
		return mv;
	}
	
	@RequestMapping(value={"beforeAction.do"})
	public String beforeAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		logger.debug("beforeAction.do");
		SessionVO sessionvo = SessionUtil.getSessionVO(request.getSession());
		User user = sessionvo.getUser();
				
		try {
			if(null != user) {
				// 로그인 히스토리 등록
				UserVO userVO = new UserVO();
				
				String ip = InetUtil.getClientIP(request);

				if(ip != null && !ip.equals("")) {
					if(ip.equals("0:0:0:0:0:0:0:1")) {
						ip = InetUtil.getCurrentEnvironmentNetworkIp();
					}
					
					userVO.setUser_id(user.getUser_id());
					userVO.setLogin_ip(ip);
					userVO.setPw_err_cnt("0");	// 비밀번호 오류 횟수
					//getLoginService().setUserSession(user);
					
					ArrayList<UserVO> list = new ArrayList<UserVO>();
					list.add(userVO);
					
					// 계정잠금 해제
					//getLoginService().updateLogin(list);
					
					//getLoginService().insertLoginHist(loginVO);
					
					/* 토큰 등록 */
					//getCommService().regiToken(user);
					
					//위에서 인증 성공했다면 엑세스 토큰 발급, 리프레시 토큰 발급
					//엑세스 토큰 발급 - User에 담긴 정보로 60분짜리 토큰 생성
					
					try {
						int accessTokenTime = Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_MINUTE);
						int refreshTokenTime = Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_MINUTE) * Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_HOUR) * Constants.getTOKEN_VALIDATE(TOKEN_VALIDATE.TOKEN_VALID_DAY);
						
						String access_token = jwtTokenUtil.userRegiToken(user, accessTokenTime);
						
						//리프레시 토큰 발급 - User에 담긴 정보로 하루짜리 토큰 생성
						String refresh_token = jwtTokenUtil.userRegiToken(user, refreshTokenTime);
						
						//세션에 등록
						user.setAccess_token(access_token);
						user.setRefresh_token(refresh_token);
					}catch(Exception e) {
						logger.error("토큰 생성 실패!!!!!!!");
						logger.error(e.getMessage());
					}
				}
			}
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		
		return "redirect:index.go";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		logger.debug("logout.do");
		logoutAction(req, res);
		return "redirect:/";
	}
	
	public void logoutAction(HttpServletRequest req, HttpServletResponse res){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
	}
}
