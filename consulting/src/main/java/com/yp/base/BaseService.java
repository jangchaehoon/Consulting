package com.yp.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yp.main.MainDAO;
import com.yp.security.UserDAO;
import com.yp.system.menu.MenuDAO;

@Service(value = "BaseService")
public class BaseService {
	
	@Autowired
	private MainDAO mainDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private UserDAO userDAO;

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
	
}
