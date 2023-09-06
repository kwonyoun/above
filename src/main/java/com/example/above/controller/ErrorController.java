package com.example.above.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ErrorController {

    @GetMapping("/denied")
    public String accessDenied(HttpServletRequest request){
        request.getAttribute("errorMessage");
        System.out.println("gerer");
        return "redirect";
    }

}
