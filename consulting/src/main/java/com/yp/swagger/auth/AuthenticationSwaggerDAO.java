package com.yp.swagger.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yp.base.BaseDAO;

@Repository(value="AuthenticationSwaggerDAO")
public class AuthenticationSwaggerDAO extends BaseDAO{

	/**
	 * @Description  : 토큰 조회
	 * @author       : lakhyun.kim
	 * @since        : 2020. 02. 06
	 * @param        : AuthenticationSwaggerVO
	 * @return       : List<Map<String, String>>
	 */
	public List<Map<String, String>> selectTokenHistList(AuthenticationSwaggerVO authenticationSwaggerVO){
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		resultList = getSqlSession().selectList(getAuthenticationswaggermapper() + "selectTokenHistList", authenticationSwaggerVO);
		return resultList;
	}

	/**
	 * @Description  : 토큰 한 건 조회
	 * @author       : lakhyun.kim
	 * @since        : 2020. 02. 06
	 * @param        : AuthenticationSwaggerVO
	 * @return       : Map<String, String>
	 */
	public Map<String, String> selectTokenHistView(AuthenticationSwaggerVO authenticationSwaggerVO){
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap = getSqlSession().selectOne(getAuthenticationswaggermapper() + "selectTokenHistView", authenticationSwaggerVO);
		return resultMap;
	}

	/**
	 * @Description  : 토큰 카운트 조회
	 * @author       : lakhyun.kim
	 * @since        : 2020. 02. 06
	 * @param        : AuthenticationSwaggerVO
	 * @return       : int
	 */
	public int selectTokenHistCheckCount(AuthenticationSwaggerVO authenticationSwaggerVO){
		int resultInt = 0;
		resultInt = getSqlSession().selectOne(getAuthenticationswaggermapper() + "selectTokenHistCheckCount", authenticationSwaggerVO);
		return resultInt;
	}
	
	/**
	 * @Description  : 토큰 등록
	 * @author       : lakhyun.kim
	 * @since        : 2020. 02. 06
	 * @param        : AuthenticationSwaggerVO
	 * @return       : int
	 */
	public int insertTokenHist(AuthenticationSwaggerVO authenticationSwaggerVO){
		int resultInt = 0;
		resultInt = getSqlSession().insert(getAuthenticationswaggermapper() + "insertTokenHist", authenticationSwaggerVO);
		return resultInt;
	}
	
}
