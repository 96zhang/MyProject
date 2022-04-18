package com.cy.store.service;

import com.cy.store.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author zss
 * @version 1.0
 * @description: 用户模块业务层接口
 * @date 2022/2/5 16:05
 */

public interface IUserService {

    /**
     * @description: 用户注册方法
     * @param: user  用户的数据对象
     * @return:
     * @author zss
     * @date: 2022/2/5 16:06
     */
    void reg(User user);
}
