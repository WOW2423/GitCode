package com.enter.entercustomerservice.exception;

/**
* @类名： UnCheckedException
*
* @author Liquid
*
* @描述： 非检查异常，系统运行中可能出现的正常异常
*
* @date   2018/12/28
*/
public class UnCheckedException extends RuntimeException{

    private static final long serialVersionUID = 400361282223628129L;

    public UnCheckedException() {
        super();
    }

    public UnCheckedException(String message) {
        super(message);
    }

    public UnCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnCheckedException(Throwable cause) {
        super(cause);
    }

    protected UnCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
