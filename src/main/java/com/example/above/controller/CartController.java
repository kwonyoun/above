package com.example.above.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.CartService;
import com.example.above.service.IndexService;
import com.example.above.vo.ProdVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    CartService svc;

    @GetMapping("/cart")
    public String index(Model model, HttpSession session, @RequestParam("prodNum") int prodNum){
        String id = (String) session.getAttribute("id");
        System.out.println("id: "+id);
        System.out.println("prodNum: "+prodNum);
        ProdVO ProdVO = svc.selectOrdProd(prodNum);
        return "index";
    }
    
}
