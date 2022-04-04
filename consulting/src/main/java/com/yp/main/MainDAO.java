package com.yp.main;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yp.base.BaseDAO;

@Repository(value = "MainDAO")
public class MainDAO extends BaseDAO {
	
	/**
	 * @Description  : DB 연결테스트
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 03
	 * @return       : List<Map<String, Object>>
	 */
	public List<Map<String, Object>> dbtest(MainVO mainVO){
		return getSqlSession().selectList(getMainmapper() + "dbTest", mainVO);
	}

}
