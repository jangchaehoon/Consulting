package com.yp.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yp.base.BaseService;
import com.yp.exception.MessageCommonCode;
import com.yp.security.model.Role;
import com.yp.security.model.User;
import com.yp.user.UserVO;

@Service(value = "CommonService")
public class CommonService extends BaseService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * @Description  : 로그인 정보 및 권한 체크
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : User
	 */
	public User getLoginAuthCheck(UserVO userVO) {
		
		User user = new User();
		String user_id = userVO.getUser_id();	// 로그인아이디
		String user_pw = userVO.getUser_pw();	// 로그인패스워드
		// String sso_key = loginVO.getSso_key();
		List<Role> roles = new ArrayList<Role>();
		
		Map<String, String> UserView = new HashMap<String, String>();	// 로그인 정보 조회 시 필수 정보 담음
		Map<String, String> RoleList = new HashMap<String, String>();	// 권한 정보 조회 시 필수 정보 담음

		UserView.put("user_id", user_id);
		
		// 사원계정 정보 획득
		user = getUserDAO().selectUserView(UserView);
		
		MessageCommonCode errorElement = null;
		String exmsg = "";
		
		if(null == user) {//유저가 없을 경우
			errorElement = MessageCommonCode.ERR0012;
			exmsg = errorElement.getMessage();
			throw new UsernameNotFoundException(exmsg);
		}else{//유저가 있을경우

			// 비밀번호 오류 횟수가 5번 이상일 경우
			/*
			if(null != user.getPw_err_cnt() && !"".equals(user.getPw_err_cnt())) {
				if(Integer.parseInt(user.getPw_err_cnt()) >= 5){
					throw new BadCredentialsException("ERROVERPWDCNT");
				}
			}
			*/
			
			if (!bCryptPasswordEncoder.matches(user_pw, user.getPassword())){//비밀번호가 틀렸을경우
				errorElement = MessageCommonCode.ERR0014;
				exmsg = errorElement.getMessage();
				throw new BadCredentialsException(exmsg);
//				throw new BadCredentialsException("ERRPWD" + user.getPw_err_cnt());
			}else{//비빌번호가 맞을 경우
				/*
				RoleList.put("user_id",user.getUser_id());
				RoleList.put("role_id",user.getRole_id());
				// 권한세팅
				roles = getUserDAO().SelectRolesHierarchyList(RoleList);
				if(null == roles){//권한이 없을경우
					errorElement = MessageCommonCode.ERR0014;
					exmsg = errorElement.getMessage();
					throw new BadCredentialsException(exmsg);
				}else{
					user.setAuthorities(roles);
				}
				*/
			}
		}
		return user;
	}
	
}
