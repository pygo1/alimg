package com.alimg.blog.exception;

/**
 * 库存不足异常
 */
public class LoginException extends RuntimeException {

	public LoginException(String message) {
		super(message);
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

}
