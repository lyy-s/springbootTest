package com.lyy.controller;

import com.lyy.dto.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class UserController {

    @RequestMapping(value ="/test1",method = RequestMethod.GET)
    public String test1(UserRequest userRequest, HttpServletRequest httpServletRequest){
        System.out.println("业务入参："+userRequest);
        //获取所有请求头
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            System.out.println(headName+":"+httpServletRequest.getHeader(headName));
        }
        return "main.html";
    }

    @PostMapping(value = "/test2")
    public String test2(UserRequest userRequest,HttpServletRequest httpServletRequest){
        System.out.println("其他业务入参："+userRequest);
        //获取所有请求头
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            System.out.println(headName+":"+httpServletRequest.getHeader(headName));
        }
        return "test2";
    }

}
