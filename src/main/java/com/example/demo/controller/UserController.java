package com.example.demo.controller;

import com.example.demo.dao.UserDao;
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
}
