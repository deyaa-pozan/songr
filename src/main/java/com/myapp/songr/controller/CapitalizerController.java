package com.myapp.songr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapitalizerController {

    @GetMapping("/capitalize/{sentence}")
    public String capitalize(Model model,@PathVariable String sentence){
        String capitalized = sentence.toUpperCase();
        model.addAttribute("sentence",capitalized);

        return "capitalize";
    }


}