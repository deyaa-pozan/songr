package com.myapp.songr.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello.html";
    }
}
