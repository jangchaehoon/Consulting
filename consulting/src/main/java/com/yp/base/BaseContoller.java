package com.yp.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.main.MainService;

public class BaseContoller {
	
	@Autowired
	private MainService mainService;

	public MainService getMainService() {
		return mainService;
	}

	public void setMainService(MainService mainService) {
		this.mainService = mainService;
	}
	
}
