package com.yp.common.util;

import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.yp.security.model.Role;

@Component(value = "SessionUtil")
public class SessionUtil {
	private static final Logger logger = LoggerFactory.getLogger(SessionUtil.class);
	
	private static Hashtable loginUsers = new Hashtable();
	/*
	 * getSessionVO
	 */
	public static SessionVO getSessionVO(HttpSession session) {
		logger.debug("SessionUtil.getSessionVO");
		
		SessionVO sessionVO = (SessionVO)session.getAttribute("sessionVO");
		return sessionVO;
	}
	/*
	 * insert SessionVO
	 */
	public static void insertSessionVO(HttpSession session, SessionVO sessionVO) {
		logger.debug("SessionUtil.insertSessionVO");
		session.setAttribute("sessionVO", sessionVO);
	}
	/*
	 * delete SessionVO
	 */
	public static void deleteSessionVO(HttpSession session) {
		logger.debug("SessionUtil.deleteSessionVO");
		session.invalidate();
	}
	
	public static Boolean getSessionAuthoritiesCheck(List<Role> authorities,String[] CheckAuthorities) {
		Boolean resultBoolean = false;
		for(int i = 0; i<authorities.size(); i++){
			
			for(int j = 0; j<CheckAuthorities.length;j++) {
				if(authorities.get(i).getName().equals(CheckAuthorities[j])) {
					resultBoolean = true;
					break;
				}
			}
			if(true == resultBoolean) {
				break;
			}
		}
		return resultBoolean;
	}	
}
