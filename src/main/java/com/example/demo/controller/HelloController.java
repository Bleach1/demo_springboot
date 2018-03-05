package com.example.demo.controller;

import com.example.demo.bean.BookBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController//标识改接口返回json格式
public class HelloController {
    @Value(value = "${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;
    @Value("${book.pinyin}")
    private String bookPinYin;

    @Autowired
    private BookBean bookBean;

    @RequestMapping(value = "/demo", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String index() {
        return "Hello Spring Boot! The BookName is " + bookName + ";and Book Author is " + bookAuthor + ";and Book PinYin is " + bookPinYin;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap();
        map.put("code", 200);
        map.put("name", bookBean.getName());
        map.put("author", bookBean.getAuthor());
        map.put("price", bookBean.getPrice());
        return map;
    }

}