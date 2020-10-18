package com.testdebuger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger("This my Controller");

    @GetMapping(value = "/")
    public String  home () {

        System.out.println();
        logger.info("info == Error Message");
        logger.debug("debug == Error Message");
        logger.trace("fatal == Error Message");
        logger.error("error == Error Message");
        logger.warn("warn == Error Message");


            return "/home";

    }

}
