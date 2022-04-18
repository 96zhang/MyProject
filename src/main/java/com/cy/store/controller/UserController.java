package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zss
 * @version 1.0
 * @description: TODO
 * @date 2022/2/5 19:01
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        JsonResult<Void> result = new JsonResult<>();
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    /**
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UsernameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        }catch (InsertException e) {
            result.setState(5000);
            result.setMessage("注册时产生未知的异常");
        }

        return result;
    }
    */


}
