package com.example.demo.mapper.test2;

import com.example.demo.bean.UserMyBatis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//MyBatis
public interface UserMapperTest2 {
    @Select("SELECT *FROM USERS WHERE NAME=#{name}")
    UserMyBatis findByName(@Param("name") String name);


    @Insert("INSERT INTO USERS(NAME,AGE) VALUES(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
