package com.yp.swagger.auth;

import java.io.Serializable;

import com.yp.base.BaseVO;

public class AuthenticationSwaggerVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -5454736900865084801L;

	private String seq;                  /* 일련번호                     BIGINT        */
	private String mb_api_id;            /* 회원사 api 로그인 ID         VARCHAR(20)   */
    private String token_type;           /* 토큰 타입                    VARCHAR(100)  */
    private String token_role;           /* API CONNECTOR 토큰 권한      VARCHAR(8)    */
    private String token_time;           /* API CONNECTOR 토큰 제한 시간 VARCHAR(8)    */
    private String token_validity_dt;    /* API CONNECTOR 토큰유효일자   DATETIME      */
    private String login_id;
    
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getMb_api_id() {
		return mb_api_id;
	}
	public void setMb_api_id(String mb_api_id) {
		this.mb_api_id = mb_api_id;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	public String getToken_role() {
		return token_role;
	}
	public void setToken_role(String token_role) {
		this.token_role = token_role;
	}
	public String getToken_time() {
		return token_time;
	}
	public void setToken_time(String token_time) {
		this.token_time = token_time;
	}
	public String getToken_validity_dt() {
		return token_validity_dt;
	}
	public void setToken_validity_dt(String token_validity_dt) {
		this.token_validity_dt = token_validity_dt;
	}
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}