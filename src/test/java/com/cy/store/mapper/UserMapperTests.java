package com.cy.store.mapper;

import com.cy.store.entity.User;
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
public class UserMapperTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void insert(){

        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void findByUsername(){
        User tim = userMapper.findByUsername("tim");
        System.out.println(tim);
    }
}
