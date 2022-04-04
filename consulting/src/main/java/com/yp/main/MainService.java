package com.yp.main;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yp.base.BaseService;

@Service(value = "MainService")
public class MainService extends BaseService {

	/**
	 * @Description  : DB 연결테스트
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 03
	 * @return       : List<Map<String, Object>>
	 */
	public List<Map<String, Object>> dbtest(MainVO mainVO){
		return getMainDAO().dbtest(mainVO);
	}
	
}
