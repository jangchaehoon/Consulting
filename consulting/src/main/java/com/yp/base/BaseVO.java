package com.yp.base;

public class BaseVO extends SearchVO {
	
	/* 기타 */
	private String seq;
	private String use_yn;
	private String sort_column;
	
	/* 사용자 */
	private String user_id;
	
	/* 입력, 수정, 삭제 */
	private String in_user_id;
	private String in_dtm;
	private String up_user_id;
	private String up_dtm;
	private String delete_yn;
	private String de_user_id;
	private String de_dtm;
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getIn_user_id() {
		return in_user_id;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getSort_column() {
		return sort_column;
	}

	public void setSort_column(String sort_column) {
		this.sort_column = sort_column;
	}

	public void setIn_user_id(String in_user_id) {
		this.in_user_id = in_user_id;
	}

	public String getIn_dtm() {
		return in_dtm;
	}

	public void setIn_dtm(String in_dtm) {
		this.in_dtm = in_dtm;
	}

	public String getUp_user_id() {
		return up_user_id;
	}

	public void setUp_user_id(String up_user_id) {
		this.up_user_id = up_user_id;
	}

	public String getUp_dtm() {
		return up_dtm;
	}

	public void setUp_dtm(String up_dtm) {
		this.up_dtm = up_dtm;
	}

	public String getDelete_yn() {
		return delete_yn;
	}

	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}

	public String getDe_user_id() {
		return de_user_id;
	}

	public void setDe_user_id(String de_user_id) {
		this.de_user_id = de_user_id;
	}

	public String getDe_dtm() {
		return de_dtm;
	}

	public void setDe_dtm(String de_dtm) {
		this.de_dtm = de_dtm;
	}
	
}
