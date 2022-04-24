package com.yp.base;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository(value = "BaseDAO")
public class BaseDAO {
	
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	private static final String mainMapper = "Main."; //main-mapper.xml
	private static final String menuMapper = "Menu."; //menu-mapper.xml
	private static final String springSecurityMapper = "SpringSecurity."; //SpringSecurity-mapper.xml
	private static final String authenticationSwaggerMapper = "AuthenticationSwagger."; //authenticationSwagger-mapper.xml
	private static final String commonCodeMapper = "CommonCode."; //commonCode-mapper.xml

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public static String getMainmapper() {
		return mainMapper;
	}

	public static String getMenumapper() {
		return menuMapper;
	}

	public static String getSpringsecuritymapper() {
		return springSecurityMapper;
	}

	public static String getAuthenticationswaggermapper() {
		return authenticationSwaggerMapper;
	}

	public static String getCommoncodemapper() {
		return commonCodeMapper;
	}
	
}
