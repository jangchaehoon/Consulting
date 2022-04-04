package com.yp.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yp.base.BaseContoller;

@Controller(value="MainController")
public class MainController extends BaseContoller {
	
	/**
	 * @Description  : DB 연결테스트
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 03
	 * @return       : List<Map<String, Object>>
	 */
	@RequestMapping(value= {"index.go"})
	public ModelAndView main(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView("/main/index");
		
		MainVO mainVO = new MainVO();
		
		mv.addObject("results", getMainService().dbtest(mainVO));
		
		return mv;
	}
}
