package com.example.above.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ErrorController {

    @GetMapping("/error/redirect")
    public String accessDenied(){
        return "error/redirect";
    }

}
