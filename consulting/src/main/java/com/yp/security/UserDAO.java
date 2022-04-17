package com.yp.security;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.yp.base.BaseDAO;
import com.yp.security.model.User;
import com.yp.user.UserVO;

@Repository("UserDAO")
public class UserDAO extends BaseDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	/**
	 * @Description  : 사용자 조회
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	public User selectUserView(Map<String, String> map){
		return getSqlSession().selectOne(getSpringsecuritymapper() + "selectUserView", map);
	}
	
	/**
	 * @Description  : 사용자 중복 확인
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	public int userIdCheck(UserVO userVO){
		return getSqlSession().selectOne(getSpringsecuritymapper() + "userIdCheck", userVO);
	}
	
	/**
	 * @Description  : 사용자 로그인정보 입력
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	public int insertLogin(UserVO userVO){
		return getSqlSession().insert(getSpringsecuritymapper() + "insertLogin", userVO);
	}
	
	/**
	 * @Description  : 사용자 입력
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	public int insertUser(UserVO userVO){
		return getSqlSession().insert(getSpringsecuritymapper() + "insertUser", userVO);
	}
	
}
