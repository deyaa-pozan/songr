package com.songr.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Locale;

@Controller
public class BasicController {

    @GetMapping("/")
    public String splashPage(Model m){
        m.addAttribute("helloWorld", "Hello World");
        return "pages/helloWorld";
    }

    @GetMapping("/hello")
    public String helloWorld(Model m){
        m.addAttribute("helloWorld", "Hello World");
        return "pages/helloWorld";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(Model m, @PathVariable String text){
        String capitalizedText = text.toUpperCase();
        m.addAttribute("helloWorld", "Hello World");
        m.addAttribute("uppercase", capitalizedText);
        return "pages/helloWorld";
    }
}
