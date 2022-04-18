package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zss
 * @version 1.0
 * @description: TODO
 * @date 2022/2/5 15:10
 */
//表示当前的类是一个测试类，不会随项目一起打包
@SpringBootTest
//表示启动这个单元测试类，需要传递一个必须是SpringRunner的实力类型
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService UserService;


    @Test
    public void reg(){

        try {
            User user = new User();
            user.setUsername("tim");
            user.setPassword("123");
            UserService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
