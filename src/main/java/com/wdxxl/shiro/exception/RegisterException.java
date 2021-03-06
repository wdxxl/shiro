package com.wdxxl.shiro.exception;

public class RegisterException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RegisterException() {
        super();
    }

    public RegisterException(String message) {
        super(message);
    }

    public RegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegisterException(Throwable cause) {
        super(cause);
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
