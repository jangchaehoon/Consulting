package com.yp.system.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yp.base.BaseController;
import com.yp.common.util.CommUtil;

@Controller(value="MenuController")
public class MenuController extends BaseController {
	
	/**
	 * @Description  : 메뉴 설정 화면 이동
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 17
	 * @return       : ModelAndView
	 */	
	@RequestMapping(value = "/system/menu/menu.go")
	public ModelAndView menu(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("/system/menu/menu");
		
		MenuVO menuVO = new MenuVO();
		mv.addObject("results", getMenuService().getMenuList(menuVO));
		
		return mv;
	}
	
	/**
	 * @Description  : 메뉴 리스트 조회 Html
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 10
	 * @return       : ModelAndView
	 */
	@RequestMapping(value = "/system/menu/getMenuTableHtml.ajax")
	public ModelAndView getMenuTableHtml(HttpServletRequest req, HttpServletResponse res, MenuVO menuVO) throws Exception {
		ModelAndView mv = new ModelAndView("/system/menu/menuTableHtml");
		
		mv.addObject("results", getMenuService().getMenuList(menuVO));
		
		return mv;
	}
	
	/**
	 * @Description  : 메뉴 리스트 조회
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 10
	 * @return       : ModelAndView
	 */
	@RequestMapping(value = "/system/menu/getMenuList.ajax")
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
	@RequestMapping(value = "/system/menu/insertMenu.ajax")
	public ModelAndView insertMenu(HttpServletRequest req, HttpServletResponse res, MenuVO menuVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		getMenuService().insertMenu(menuVO);
		
		return mv;
	}
}
