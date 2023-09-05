package com.example.above.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.MemService;
import com.example.above.vo.MemVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    MemService memService;

    @GetMapping("/login")
    public String loginMain() {
        return "login";
    }

    @GetMapping("/admin")
    public String loginAdmin() {
        return "admin";
    }

    // @PostMapping("/login")
    // public String login(@RequestParam("memId") String id, @RequestParam("memPw") String pw, HttpSession session) {
    //    MemVO login = memService.selectMem(id,pw);

    //    if(login ==null) {
    //         System.out.println("실패");
    //    } else {
    //         System.out.println("성공");
    //         session.setAttribute("id", login.getMemId());
    //    }

    //    return "redirect:";
    // }
}
