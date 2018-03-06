package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createUser(String name, Integer age) {
        jdbcTemplate.update("insert into users values (null ,?,?);", name, age);
    }

}
