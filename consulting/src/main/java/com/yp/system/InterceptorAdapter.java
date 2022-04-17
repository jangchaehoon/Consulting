package com.yp.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yp.system.menu.MenuService;
import com.yp.system.menu.MenuVO;

public class InterceptorAdapter extends HandlerInterceptorAdapter {
	
	@Autowired
	private MenuService menuService;
	
	// Controller 실행전 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		MenuVO menuVO = new MenuVO();
		
		request.setAttribute("menuList", menuService.getMenuList(menuVO));
		
		return true;
	}
	
	// Controller 실행후 처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}
	
	// Controller 실행후 View 실행 후 처리
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}
