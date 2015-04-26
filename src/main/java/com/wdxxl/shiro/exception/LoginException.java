package com.wdxxl.shiro.exception;

public class LoginException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
