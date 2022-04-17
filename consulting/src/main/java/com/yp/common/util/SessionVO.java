package com.yp.common.util;

import java.io.Serializable;

import org.springframework.security.core.Authentication;

import com.yp.base.BaseVO;
import com.yp.security.model.User;

public class SessionVO extends BaseVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8090771433291706228L;
	
	private String sessionID;
	private String location;
	private User user;
	private Authentication auth;
	
	private String DEVICE;
	private String DEVICE_SIZE;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDEVICE() {
		return DEVICE;
	}
	public void setDEVICE(String dEVICE) {
		DEVICE = dEVICE;
	}
	public String getDEVICE_SIZE() {
		return DEVICE_SIZE;
	}
	public void setDEVICE_SIZE(String dEVICE_SIZE) {
		DEVICE_SIZE = dEVICE_SIZE;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Authentication getAuth() {
		return auth;
	}
	public void setAuth(Authentication auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "SessionVO [sessionID=" + sessionID + ", user=" + user + ", auth=" + auth
				+ ", DEVICE=" + DEVICE + ", DEVICE_SIZE=" + DEVICE_SIZE + "]";
	}
	
	
	
}
