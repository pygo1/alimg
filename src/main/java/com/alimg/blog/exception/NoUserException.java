package com.alimg.blog.exception;

/**
 * 登录异常
 */
public class NoUserException extends RuntimeException {

	public NoUserException(String message) {
		super(message);
	}

	public NoUserException(String message, Throwable cause) {
		super(message, cause);
	}

}
