package com.testdebuger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping(value = "/user")
    public String user () {
        return "/user";
    }

}
