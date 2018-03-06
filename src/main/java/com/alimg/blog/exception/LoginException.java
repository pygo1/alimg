package com.alimg.blog.exception;

/**
 * 登录异常
 */
public class LoginException extends RuntimeException {

	public LoginException(String message) {
		super(message);
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

}
