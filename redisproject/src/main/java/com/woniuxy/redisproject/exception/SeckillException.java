package com.woniuxy.redisproject.exception;

/**
 * @author Administrator
 * @Description TODO
 * @date 2019/9/26
 */
public class SeckillException extends RuntimeException {
    public SeckillException() {
        super();
    }

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillException(Throwable cause) {
        super(cause);
    }

    protected SeckillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
