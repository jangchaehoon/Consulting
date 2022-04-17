package com.yp.exception;

public interface IMessageCodeable {
	String getMessageCode();
	String getMessage(String... args);
}