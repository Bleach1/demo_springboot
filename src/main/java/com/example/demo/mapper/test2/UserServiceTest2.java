package com.example.demo.mapper.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceTest2 {
    @Autowired
    private UserMapperTest2 userMapperTest2;


    @Transactional//整合事物  回滚
    public String insertTest2(String name, Integer age) {
        userMapperTest2.insert(name, age);
        int i = 1 / 0;
        return "Success";
    }

}
