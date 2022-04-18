package com.cy.store.util;

import java.io.Serializable;

/**
 * @author zss
 * @version 1.0
 * @description: Json格式数据响应
 * @date 2022/2/5 18:53
 */
public class JsonResult<E> implements Serializable {
    /**  状态码  */
    private Integer state;
    /** 描述信息 */
    private String message;
    /** 数据 */
    private E data;

    public JsonResult() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
}
