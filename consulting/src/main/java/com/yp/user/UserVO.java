package com.yp.user;

import com.yp.base.BaseVO;

public class UserVO extends BaseVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String login_ip;     /* 로그인IP   VARCHAR(40)  */
    private String login_dtm;    /* 로그인일시 DATETIME     */
	private String pw_err_cnt;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLogin_ip() {
		return login_ip;
	}
	public void setLogin_ip(String login_ip) {
		this.login_ip = login_ip;
	}
	public String getLogin_dtm() {
		return login_dtm;
	}
	public void setLogin_dtm(String login_dtm) {
		this.login_dtm = login_dtm;
	}
	public String getPw_err_cnt() {
		return pw_err_cnt;
	}
	public void setPw_err_cnt(String pw_err_cnt) {
		this.pw_err_cnt = pw_err_cnt;
	}
	
	
}
