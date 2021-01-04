package com.woniuxy.courseservice.exception;

public class SubscribeException extends RuntimeException {
    public SubscribeException() {
        super();
    }

    public SubscribeException(String message) {
        super(message);
    }

    public SubscribeException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubscribeException(Throwable cause) {
        super(cause);
    }

    protected SubscribeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
