package com.yp.system.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yp.base.BaseDAO;
import com.yp.common.util.CommUtil;

@Repository(value = "MenuDAO")
public class MenuDAO extends BaseDAO {
	
	/**
	 * @Description  : 메뉴 리스트 조회
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 10
	 * @return       : List<Map<String, Object>>
	 */
	public List<Map<String, Object>> selectMenuList(MenuVO menuVO){
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		
		if(CommUtil.isNotEmpty(menuVO.getPage())) {
			if(CommUtil.isEmpty(menuVO.getSort_column())) {
				menuVO.setSort_column("1");
			}
			result = getSqlSession().selectList(getMenumapper() + "selectMenuListPaging", menuVO);
		} else {
			result = getSqlSession().selectList(getMenumapper() + "selectMenuList", menuVO);
		}
		return result;
	}
	
	/**
	 * @Description  : 메뉴 단건 조회
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 23
	 * @return       : List<Map<String, Object>>
	 */
	public Map<String, Object> selectMenuView(MenuVO menuVO){
		return getSqlSession().selectOne(getMenumapper() + "selectMenuView", menuVO);
	}
	
	/**
	 * @Description  : 메뉴 리스트 입력
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : int
	 */
	public int insertMenu(MenuVO menuVO){
		return getSqlSession().insert(getMenumapper() + "insertMenu", menuVO);
	}
	
	/**
	 * @Description  : 메뉴 리스트 수정
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : int
	 */
	public int updateMenu(MenuVO menuVO){
		return getSqlSession().update(getMenumapper() + "updateMenu", menuVO);
	}
	
	/**
	 * @Description  : 메뉴 리스트 삭제
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : int
	 */
	public int deleteMenu(MenuVO menuVO){
		return getSqlSession().update(getMenumapper() + "deleteMenu", menuVO);
	}

}
