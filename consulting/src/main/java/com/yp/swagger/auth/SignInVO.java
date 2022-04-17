package com.yp.swagger.auth;

import io.swagger.annotations.ApiModelProperty;
import com.yp.base.BaseVO;

public class SignInVO extends BaseVO{

	@ApiModelProperty(value="로그인ID",allowEmptyValue=false,hidden=false)
	private String mb_api_id;
	@ApiModelProperty(value="비밀번호",allowEmptyValue=false,hidden=false)
	private String mb_api_pwd;

	public String getMb_api_id() {
		return mb_api_id;
	}
	public void setMb_api_id(String mb_api_id) {
		this.mb_api_id = mb_api_id;
	}
	public String getMb_api_pwd() {
		return mb_api_pwd;
	}
	public void setMb_api_pwd(String mb_api_pwd) {
		this.mb_api_pwd = mb_api_pwd;
	}
	
}
