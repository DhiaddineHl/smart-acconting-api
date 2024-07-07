package com.wind.windrecruitmentapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetController {

    @GetMapping
    public String sayHello(){
        return "Hello world";
    }

}
