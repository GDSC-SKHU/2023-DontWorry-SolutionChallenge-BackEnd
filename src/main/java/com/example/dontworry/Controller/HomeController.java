package com.example.dontworry.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
