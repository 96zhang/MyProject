package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author zss
 * @version 1.0
 * @description: 用户模块的实现类
 * @date 2022/2/5 16:08
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //先判断是否被注册过
        User result = userMapper.findByUsername(user.getUsername());
        if(result != null){
            //抛出异常
            throw new UsernameDuplicatedException("用户名被占用");
        }

        //密码加密处理 md5算法
        //加密形式：  字符串（盐值）+密码+串  然后md5算法加密  连续加载三次
        String oldPassword = user.getPassword();
        //获取盐值（随机生成一个）
        String salt = UUID.randomUUID().toString().toUpperCase();
        //保存盐值
        user.setSalt(salt);
        //加密处理
        String md5Password = getMD5Password(user.getPassword(),salt);
        //将加密后的密码给到user
        user.setPassword(md5Password);


        // 补全数据：isDelete(0)
        user.setIsDelete(0);
        // 补全数据：4项日志属性
        Date date = new Date();
        user.setCreatedUser(user.getUsername());
        user.setCreatedTime(date);
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(date);

        //注册实现 rows 为1
        Integer rows = userMapper.insert(user);
        if(rows != 1){
            throw new InsertException("在用户注册过程中产生了未知异常");
        }
    }


    /**
     * @description: 定义一个MD5算法加密处理
     * @param: passward  原密码
               salt       盐值
     * @return:   加密后密码
     * @author zss
     * @date: 2022/2/5 16:37
     */
    private String getMD5Password(String password, String salt){
        for (int i=0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }

        return password;
    }
}
