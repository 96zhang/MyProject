package com.cy.store.controller;

import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zss
 * @version 1.0
 * @description: TODO
 * @date 2022/2/5 19:16
 */
public class BaseController {

    public static final int OK = 200 ;

    /** @ExceptionHandler用于统一处理方法抛出的异常 */
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> jsonResult = new JsonResult<>();
        if(e instanceof UsernameDuplicatedException){
            jsonResult.setState(4000);
            jsonResult.setMessage("用户名已经被占用");
        }else if (e instanceof InsertException){
            jsonResult.setState(5000);
            jsonResult.setMessage("注册时产生未知的异常");
        }

        return jsonResult;
    }
}
