package com.cy.store.service.ex;

/**
 * @author zss
 * @version 1.0
 * @description:业务层异常的基类
 * @date 2022/2/5 15:57
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
