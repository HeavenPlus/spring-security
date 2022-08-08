package com.heaven.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhanggq
 * @date 2022/8/8 14:38
 */
@Controller
public class LoginController {

    @RequestMapping("/toLoginPage")
    public String toLoginPage() {
        return "login";
    }
}
