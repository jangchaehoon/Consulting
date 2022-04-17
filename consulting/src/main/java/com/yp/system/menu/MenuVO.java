package com.yp.system.menu;

import com.yp.base.BaseVO;

public class MenuVO extends BaseVO {
	
	private String menu_id;
	private String menu_type;
	private String menu_name;
	private String menu_img_file_seq;
	private String menu_pattren;
	private String menu_url;
	private String parents_menu_id;
	
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_type() {
		return menu_type;
	}
	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public String getMenu_img_file_seq() {
		return menu_img_file_seq;
	}
	public void setMenu_img_file_seq(String menu_img_file_seq) {
		this.menu_img_file_seq = menu_img_file_seq;
	}
	public String getMenu_pattren() {
		return menu_pattren;
	}
	public void setMenu_pattren(String menu_pattren) {
		this.menu_pattren = menu_pattren;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public String getParents_menu_id() {
		return parents_menu_id;
	}
	public void setParents_menu_id(String parents_menu_id) {
		this.parents_menu_id = parents_menu_id;
	}
	
}
