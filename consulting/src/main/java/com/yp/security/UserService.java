package com.yp.security;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yp.base.BaseService;
import com.yp.security.model.User;
import com.yp.user.UserVO;
import com.yp.user.login.LoginVO;

@Service("UserService")
public class UserService extends BaseService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	/**
	 * @Description  : 사용자 조회
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : User
	 */
	public User getUserView(Map<String, String> map){
		User user = null;
		try {
			user = getUserDAO().selectUserView(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return user;
	}
	
	/**
	 * @Description  : 사용자 중복 확인
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : int
	 */
	public int userIdCheck(UserVO userVO){
		return getUserDAO().userIdCheck(userVO);
	}
	
	/**
	 * @Description  : 사용자 입력
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : void
	 */
	public void insertUser(UserVO userVO){
		getUserDAO().insertLogin(userVO);
		getUserDAO().insertUser(userVO);
	}
	
}