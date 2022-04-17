package com.yp.swagger.auth;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yp.base.BaseService;
import com.yp.common.util.JwtTokenUtil;
import com.yp.exception.MessageCommonCode;

@Service(value = "AuthenticationSwaggerService")
public class AuthenticationSwaggerService extends BaseService{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSwaggerService.class);

	/**
	 * @Description  : 회원사 로그인 정보 체크 및 토큰생성
	 * @author       : lakhyun.kim
	 * @since        : 2020. 02. 05
	 * @param        : LoginVO
	 * @return       : User
	 */
	public String getMemberLoginAuthCheck(SignInVO signInVO) {

		Map<String, String> MemberView = new HashMap<String, String>();
		String JSON_WEB_TOKEN = "";
		
		MessageCommonCode errorElement = null;
		String exmsg = "";

		if(null == signInVO) {//유저가 없을 경우
			errorElement = MessageCommonCode.ERR0012;
			exmsg = errorElement.getMessage();
			throw new UsernameNotFoundException(exmsg);
		}else {
			JwtTokenUtil jtu = new JwtTokenUtil();
			
			Map<String, Object> claims = new HashMap<>();
			
			final long JWT_TOKEN_VALIDITY = Integer.parseInt(signInVO.getSession_time()) * 60;
			
			JSON_WEB_TOKEN = jtu.generateToken(claims,signInVO.getUser_id(),JWT_TOKEN_VALIDITY);
			logger.debug(JSON_WEB_TOKEN);
			
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			AuthenticationSwaggerVO authenticationSwaggerVO = new AuthenticationSwaggerVO();
			authenticationSwaggerVO.setUser_id(signInVO.getUser_id());
			authenticationSwaggerVO.setToken(JSON_WEB_TOKEN);
			authenticationSwaggerVO.setToken_type("JWT");
			authenticationSwaggerVO.setToken_role(signInVO.getRole_id());
			authenticationSwaggerVO.setToken_time(signInVO.getSession_time());
			authenticationSwaggerVO.setToken_validity_dt(transFormat.format(jtu.getExpirationDateFromToken(JSON_WEB_TOKEN)));
			
			// 토큰 저장
			getAuthenticationSwaggerDAO().insertTokenHist(authenticationSwaggerVO);
		}
		
		return JSON_WEB_TOKEN;
	}
	
	/**
	 * @Description  : 토큰 등록
	 * @author       : minho.kim
	 * @since        : 2020. 03. 02
	 * @param        : AuthenticationSwaggerVO
	 * @return       : int
	 */
	public int insertTokenHist(AuthenticationSwaggerVO authenticationSwaggerVO){
		int resultInt = 0;
		resultInt = getAuthenticationSwaggerDAO().insertTokenHist(authenticationSwaggerVO);
		return resultInt;
	}
	
}
