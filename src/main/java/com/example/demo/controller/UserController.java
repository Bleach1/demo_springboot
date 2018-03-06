package com.example.demo.controller;

import com.example.demo.bean.UserMyBatis;
import com.example.demo.dao.UserDao;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.test1.UserMapperTest1;
import com.example.demo.mapper.test1.UserServiceTest1;
import com.example.demo.mapper.test2.UserMapperTest2;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMapperTest1 userMapperTest1;

    @Autowired
    private UserMapperTest2 userMapperTest2;


    @Autowired
    private UserServiceTest1 userServiceTest1;


    @RequestMapping("/createUser")
    public String createUser_JDBC(String name, Integer age) {
        userService.createUser(name, age);
        return "success";
    }

    @RequestMapping("/getUser")
    public String getUser(Integer id) {
        userDao.findOne(id);
        return "success";
    }

    @RequestMapping("/findByName")
    public UserMyBatis findByName(String name) {
        return userMapper.findByName(name);
    }

    @RequestMapping("/insert")
    public String insert(String name, Integer age) {
        userMapper.insert(name, age);
        return "Success";
    }


    @RequestMapping("/insertTest1")
    public String insertTest1(String name, Integer age) {
        userServiceTest1.insertTest1(name, age);
        // userMapperTest1.insert(name, age);
        return "Success";
    }

    @RequestMapping("/insertTest2")
    public String insertTest2(String name, Integer age) {
        userMapperTest2.insert(name, age);
        return "Success";
    }


}
