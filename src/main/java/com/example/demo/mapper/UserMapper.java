package com.example.demo.mapper;

import com.example.demo.bean.UserMyBatis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//MyBatis
public interface UserMapper {
    @Select("SELECT *FROM USERS WHERE NAME=#{name}")
    UserMyBatis findByName(@Param("name") String name);


    @Insert("INSERT INTO USERS(NAME,AGE) VALUES(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
