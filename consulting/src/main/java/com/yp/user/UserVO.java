package com.yp.user;

import com.yp.base.BaseVO;

public class UserVO extends BaseVO {
	private String login_ip;     /* 로그인IP   VARCHAR(40)  */
    private String login_dtm;    /* 로그인일시 DATETIME     */
	private String pw_err_cnt;
	
	private String access_token;
	private String refresh_token;
	
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
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	
}
