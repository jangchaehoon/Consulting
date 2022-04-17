package com.yp.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yp.main.MainService;
import com.yp.security.UserService;
import com.yp.system.menu.MenuService;

@Controller(value="BaseController")
public class BaseController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;

	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
