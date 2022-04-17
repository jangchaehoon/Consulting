package com.yp.system.menu;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yp.base.BaseService;

@Service(value = "MenuService")
public class MenuService extends BaseService {

	/**
	 * @Description  : 메뉴 리스트 조회
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 10
	 * @return       : List<Map<String, Object>>
	 */
	public List<Map<String, Object>> getMenuList(MenuVO menuVO){
		return getMenuDAO().selectMenuList(menuVO);
	}
	
	/**
	 * @Description  : 메뉴 리스트 입력
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : int
	 */
	public int insertMenu(MenuVO menuVO){
		return getMenuDAO().insertMenu(menuVO);
	}
	
	/**
	 * @Description  : 메뉴 리스트 수정
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : int
	 */
	public int updateMenu(MenuVO menuVO){
		return getMenuDAO().updateMenu(menuVO);
	}
	
	/**
	 * @Description  : 메뉴 리스트 삭제
	 * @author       : JANGCHAEHOON
	 * @since        : 2022. 04. 16
	 * @return       : int
	 */
	public int deleteMenu(MenuVO menuVO){
		return getMenuDAO().deleteMenu(menuVO);
	}
	
}
