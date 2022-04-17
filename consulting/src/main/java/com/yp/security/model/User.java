package com.yp.security.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.annotations.ApiModelProperty;


public class User implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private List<Role> authorities;
	
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	@ApiModelProperty(allowEmptyValue=false,hidden=true)//enabled 숨김처리
	private boolean enabled = true;
	@ApiModelProperty(allowEmptyValue=false,hidden=true)//username 숨김처리
	private String username;
	
	@ApiModelProperty(value="로그인ID",allowEmptyValue=false,hidden=false)
	private String user_id;
	@ApiModelProperty(value="비밀번호",allowEmptyValue=false,hidden=true)//비밀번호는 숨김처리
	private String password;
	@ApiModelProperty(value="권한",allowEmptyValue=false,hidden=false)
	private String role_id;
	@ApiModelProperty(value="핸드폰번호",allowEmptyValue=false,hidden=false)
	private String hpno;
	@ApiModelProperty(value="집전화",allowEmptyValue=false,hidden=false)
	private String telno;
	@ApiModelProperty(value="이메일",allowEmptyValue=false,hidden=false)
	private String email;
	@ApiModelProperty(value="계정잠김여부",allowEmptyValue=false,hidden=false)
	private String acct_lock_type;
	@ApiModelProperty(value="최종로그인시간",allowEmptyValue=false,hidden=false)
	private String login_time;
	@ApiModelProperty(value="세션시간",allowEmptyValue=false,hidden=false)
	private int session_time;

	private String pw_err_cnt;
	
	public Collection<? extends GrantedAuthority> getAuthorities() { return this.authorities; } 
	
	public boolean isAccountNonExpired() { return this.accountNonExpired; } 
	
	public void setAccountNonExpired(boolean accountNonExpired) { this.accountNonExpired = accountNonExpired; } 
	
	public boolean isAccountNonLocked() { return this.accountNonLocked; } 
	
	public void setAccountNonLocked(boolean accountNonLocked) { this.accountNonLocked = accountNonLocked; }
	
	public boolean isCredentialsNonExpired() { return this.credentialsNonExpired; } 
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) { this.credentialsNonExpired = credentialsNonExpired; } 
	
	public boolean isEnabled() { return this.enabled; } 
	
	public void setEnabled(boolean enabled) { this.enabled = enabled; }

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getHpno() {
		return hpno;
	}

	public void setHpno(String hpno) {
		this.hpno = hpno;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAcct_lock_type() {
		return acct_lock_type;
	}

	public void setAcct_lock_type(String acct_lock_type) {
		this.acct_lock_type = acct_lock_type;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

	public int getSession_time() {
		return session_time;
	}

	public void setSession_time(int session_time) {
		this.session_time = session_time;
	}

	public String getPw_err_cnt() {
		return pw_err_cnt;
	}

	public void setPw_err_cnt(String pw_err_cnt) {
		this.pw_err_cnt = pw_err_cnt;
	}

}
