package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FreeMarkerController {

    @RequestMapping("/freemarker")
    public String hello(Map<String, Object> map) {
        map.put("name", "[Polaris -- 北极星]");
        return "hello_freemarker";
    }
}
