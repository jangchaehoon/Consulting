package com.yp.security;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yp.base.BaseService;
import com.yp.common.CommonService;
import com.yp.security.model.User;
import com.yp.user.UserVO;
import com.yp.user.login.LoginVO;

@Component
public class CustomAuthenticationProvider extends BaseService implements AuthenticationProvider {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

		
	@Autowired
	private CommonService commService;
	
	@SuppressWarnings("unchecked")
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		User user = new User();
		String user_id = authentication.getName();// 로그인아이디
		String user_pw = (String) authentication.getCredentials();//로그인패스워드
		// String LOGIN_SSO_KEY = "";
		
		Collection<? extends GrantedAuthority> authorities = null;
		Map<String, String> loginData = new HashMap<String, String>();//로그인데이터정보 담음
		
		// 기타정보 획득
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Enumeration<?> param = request.getParameterNames();
		
		while (param.hasMoreElements()){
			String name = (String)param.nextElement();
			
			// 비밀번호의 경우 여기에 등록하지 않음
			if(name.toLowerCase().equals("password")) continue;
			
			loginData.put(name.toLowerCase(), request.getParameter(name));
		}
		
		if(null!=loginData) {
			// LOGIN_SSO_KEY = null == loginData.get("sso_key") ? "" : loginData.get("sso_key");
		}
		
		UserVO userVO = new UserVO();
		userVO.setUser_id(user_id);
		userVO.setUser_pw(user_pw);
		// loginVO.setSso_key(LOGIN_SSO_KEY);
		
		user = commService.getLoginAuthCheck(userVO);
		authorities = user.getAuthorities();
		return new UsernamePasswordAuthenticationToken(user, user_pw, authorities);
	}

	
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
