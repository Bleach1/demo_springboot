package com.example.demo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.example.demo.*")
@EnableJpaRepositories("com.example.demo.dao")
@EntityScan("com.example.demo.bean")
@MapperScan(basePackages = "com.example.demo.mapper")
@EnableScheduling
//@EnableConfigurationProperties(value = {DBConfigTest1.class, DBConfigTest2.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
