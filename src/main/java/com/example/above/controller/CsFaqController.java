package com.example.above.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.above.service.MemService;

@Controller
public class CsFaqController {

    @Autowired
    MemService memService;

    @GetMapping("/cscenter")
    public String cscentrFaq() {
        return "csFaq";
    }

    @GetMapping("/cscenter/faq/search")
    public String faqWrite() {
        return "cs";
    }



    
}
