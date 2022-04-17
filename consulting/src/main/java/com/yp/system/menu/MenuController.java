package com.yp.system.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yp.base.BaseController;

@Controller(value="MenuController")
public class MenuController extends BaseController {
	
	/**
	 * @Description  : 메뉴 리스트 조회
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 10
	 * @return       : ModelAndView
	 */
	@RequestMapping(value = "/menu/getMenuList.ajax")
	public ModelAndView getMenuList(HttpServletRequest req, HttpServletResponse res, MenuVO menuVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		mv.addObject("results", getMenuService().getMenuList(menuVO));
		
		return mv;
	}
	
	/**
	 * @Description  : 메뉴 리스트 입력
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	@RequestMapping(value = "/menu/insertMenu.ajax")
	public ModelAndView insertMenu(HttpServletRequest req, HttpServletResponse res, MenuVO menuVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		getMenuService().insertMenu(menuVO);
		
		return mv;
	}
}
