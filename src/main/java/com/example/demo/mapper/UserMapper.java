package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT *FROM USERS WHERE NAME=#{name}")
    User findByName(@Param("name") String name);
}
