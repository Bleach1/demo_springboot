package com.example.demo.mapper.test1;

import com.example.demo.mapper.test2.UserMapperTest2;
import com.example.demo.mapper.test2.UserServiceTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceTest1 {
    @Autowired
    private UserMapperTest1 userMapperTest1;

    @Autowired
    private UserMapperTest2 userMapperTest2;

    @Autowired
    private UserServiceTest2 userServiceTest2;

    @Transactional//整合事物  回滚
    public String insertTest1(String name, Integer age) {
        userMapperTest1.insert(name, age);
        userMapperTest2.insert(name, age);//不会回滚   分布式 可以
        // userServiceTest2.insertTest2(name, age);
        int i = 1 / 0;
        return "Success";
    }


    @Async//异步
    public void sendMsg() {
        System.out.print("异步执行函数");
    }


}
