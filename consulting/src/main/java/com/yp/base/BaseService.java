package com.yp.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.yp.main.MainDAO;

public class BaseService {
	
	@Autowired
	private MainDAO mainDAO;

	public MainDAO getMainDAO() {
		return mainDAO;
	}

	public void setMainDAO(MainDAO mainDAO) {
		this.mainDAO = mainDAO;
	}
	
}
