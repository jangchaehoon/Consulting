package com.yp.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yp.config.Constants;
import com.yp.main.MainDAO;
import com.yp.security.UserDAO;
import com.yp.security.model.User;
import com.yp.swagger.auth.AuthenticationSwaggerDAO;
import com.yp.system.menu.MenuDAO;

@Service(value = "BaseService")
public class BaseService {
	
	private User UserSession;
	
	private Constants constants;
	
	@Autowired
	private MainDAO mainDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AuthenticationSwaggerDAO authenticationSwaggerDAO;
	
	public User getUserSession() {
		return UserSession;
	}

	public void setUserSession(User userSession) {
		UserSession = userSession;
	}

	public Constants getConstants() {
		return constants;
	}

	public void setConstants(Constants constants) {
		this.constants = constants;
	}

	public MainDAO getMainDAO() {
		return mainDAO;
	}

	public void setMainDAO(MainDAO mainDAO) {
		this.mainDAO = mainDAO;
	}

	public MenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public AuthenticationSwaggerDAO getAuthenticationSwaggerDAO() {
		return authenticationSwaggerDAO;
	}

	public void setAuthenticationSwaggerDAO(AuthenticationSwaggerDAO authenticationSwaggerDAO) {
		this.authenticationSwaggerDAO = authenticationSwaggerDAO;
	}
	
}
