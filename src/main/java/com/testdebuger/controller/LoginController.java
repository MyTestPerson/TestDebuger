package com.testdebuger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @GetMapping(value = "/login")
    public String loginGet () {
        return "/login";
    }


    @PostMapping(value = "/login")
    public String loginPost () {
        return "/login";
    }

}
