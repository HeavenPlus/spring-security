package com.heaven.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanggq
 * @date 2022/8/8 11:44
 */
@RestController
@RequestMapping(value = "/hello")
public class DemoController {

    @GetMapping(value = "/test")
    public String hello(){
        return "hello spring security";
    }
}
