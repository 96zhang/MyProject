package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.springframework.stereotype.Component;

/* 用户模块的持久层接口 */
/**
 * @description: 
 * @author zss
 * @date 2022/2/5 14:32
 * @version 1.0
 */


public interface UserMapper {
   /** 
    * @description: 
    * @param: user
    * @return: 受影响的行数
    * @author zss
    * @date: 2022/2/5 14:07
    */ 
    Integer insert(User user);

    /**
     * @param: username
     * @return:如果找到对应的用户则返回这个用户的数据，没有返回null
     * @date: 2022/2/5 14:18
     */
    User findByUsername(String username);
}
