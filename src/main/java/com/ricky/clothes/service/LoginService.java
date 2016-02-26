package com.ricky.clothes.service;

import com.ricky.clothes.mapper.UserMapper;
import com.ricky.clothes.model.User;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by caiqing on 16/2/26.
 */
@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    public User findByNameAndPwd(String name, String password) {
        return userMapper.selectByNameAndPassword(name, password);
    }
}
