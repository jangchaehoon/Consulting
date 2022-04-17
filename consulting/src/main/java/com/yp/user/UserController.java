package com.yp.user;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yp.base.BaseController;

@Controller(value="UserController")
public class UserController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/**
	 * @Description  : 회원가입 약관동의 페이지 이동
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 10
	 * @return       : ModelAndView
	 */
	@RequestMapping(value="/user/joinAgree.go")
	public ModelAndView joinAgree(HttpServletRequest req, HttpServletRequest res) throws Exception{
		ModelAndView mv = new ModelAndView("/user/joinAgree");
		
		return mv;
	}
	
	/**
	 * @Description  : 회원가입 페이지 이동
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	@RequestMapping(value="/user/join.go")
	public ModelAndView join(HttpServletRequest req, HttpServletRequest res) throws Exception{
		ModelAndView mv = new ModelAndView("/user/join");
		
		return mv;
	}
	
	/**
	 * @Description  : 사용자 중복 확인
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	@RequestMapping(value="/user/userIdCheck.ajax")
	public ModelAndView userIdCheck(HttpServletRequest req, HttpServletRequest res, UserVO userVO) throws Exception{
		ModelAndView mv = new ModelAndView("jsonView");
		
		mv.addObject("result", getUserService().userIdCheck(userVO));
		
		return mv;
	}
	
	/**
	 * @Description  : 사용자 중복 확인
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : ModelAndView
	 */
	@RequestMapping(value="/user/insertUser.ajax")
	public String insertUser(HttpServletRequest req, HttpServletRequest res, UserVO userVO) throws Exception{
		
		getUserService().insertUser(userVO);
		
		return "redirect:/index.go";
	}
}
