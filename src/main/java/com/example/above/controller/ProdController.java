package com.example.above.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.ProdService;
import com.example.above.vo.ProdVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProdController {

    @Autowired
    ProdService svc;

    @GetMapping("/prod")
    public String showProd(Model model, @RequestParam("prodNum") int prodnum, HttpSession session) {
        ProdVO vo = svc.selectProd(prodnum);
        model.addAttribute("vo", vo);
        return "prodView";
    }
    
}
