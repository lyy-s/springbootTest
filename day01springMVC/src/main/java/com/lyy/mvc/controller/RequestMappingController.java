package com.lyy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class RequestMappingController {

    @RequestMapping(value = {"/testRequestMapping","/test"},
    method = {RequestMethod.POST,RequestMethod.GET},
    params = {"username"})
    public String testRequestMapping(){
        return "success";
    }

    @GetMapping(value = "/testParam",params = {"username","password"})
    public String testRequestParam(){
        return "success";
    }

    @RequestMapping("/a?a/testAnt")
    public String testRequestAnt(){
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id, @PathVariable("username")
            String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }
//最终输出的内容为-->id:1,username:admin
}
