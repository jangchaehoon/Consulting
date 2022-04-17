package com.yp.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yp.base.BaseController;
import com.yp.common.util.SessionUtil;
import com.yp.common.util.SessionVO;
import com.yp.security.model.User;

@Controller(value="MainController")
public class MainController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * @Description  : DB 연결테스트
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 03
	 * @return       : List<Map<String, Object>>
	 */
	@RequestMapping(value= {"index.go"})
	public ModelAndView main(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mv = new ModelAndView("/main/index");
		logger.debug("terst");
		
		MainVO mainVO = new MainVO();
		
		mv.addObject("results", getMainService().dbtest(mainVO));
		
		return mv;
	}
}
