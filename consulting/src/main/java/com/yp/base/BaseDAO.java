package com.yp.base;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public class BaseDAO {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	private static final String mainMapper = "Main."; //main-mapper.xml

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public static String getMainmapper() {
		return mainMapper;
	}
	
}
