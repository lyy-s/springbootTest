package com.lyy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test")
public class RequestMappingController {

    @RequestMapping(value = {"/testRequestMapping","/test"})
    public String testRequestMapping(){
        return "success";
    }


}
