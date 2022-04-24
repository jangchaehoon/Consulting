package com.yp.system.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yp.base.BaseController;
import com.yp.common.util.SessionUtil;
import com.yp.security.model.User;

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
	 * @Description  : 메뉴 입력/수정 Html
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 23
	 * @return       : ModelAndView
	 */
	@RequestMapping(value = "/system/menu/menuRegiHtml.pop")
	public ModelAndView menuRegiHtml(HttpServletRequest req, HttpServletResponse res, MenuVO menuVO) throws Exception {
		ModelAndView mv = new ModelAndView("/system/menu/menuRegiHtml");
		
		if(!"".equals(menuVO.getSeq()) && menuVO.getSeq() != null) {
			mv.addObject("MenuVO", getMenuService().getMenuView(menuVO));
		}
		
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
		
		User user = SessionUtil.getSessionVO(req.getSession()).getUser();
		
		String user_id = user.getUser_id();
		menuVO.setIn_user_id(user_id);
		
		getMenuService().insertMenu(menuVO);
		
		return mv;
	}
	
	/**
	 * @Description  : 메뉴 리스트 수정
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 23
	 * @return       : ModelAndView
	 */
	@RequestMapping(value = "/system/menu/updateMenu.ajax")
	public ModelAndView updateMenu(HttpServletRequest req, HttpServletResponse res, MenuVO menuVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		User user = SessionUtil.getSessionVO(req.getSession()).getUser();
		
		String user_id = user.getUser_id();
		menuVO.setIn_user_id(user_id);
		menuVO.setUp_user_id(user_id);
		
		getMenuService().updateMenu(menuVO);
		
		return mv;
	}
	
	/**
	 * @Description  : 메뉴 리스트 삭제
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 23
	 * @return       : ModelAndView
	 */
	@RequestMapping(value = "/system/menu/deleteMenu.ajax")
	public ModelAndView deleteMenu(HttpServletRequest req, HttpServletResponse res, MenuVO menuVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		User user = SessionUtil.getSessionVO(req.getSession()).getUser();
		
		String user_id = user.getUser_id();
		menuVO.setIn_user_id(user_id);
		menuVO.setUp_user_id(user_id);
		
		getMenuService().deleteMenu(menuVO);
		
		return mv;
	}
}
