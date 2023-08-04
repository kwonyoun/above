package com.example.above.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.above.service.MemService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @Autowired
    MemService memService;

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.removeAttribute("id");
		return "redirect:/";

    }

}
