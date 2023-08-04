package com.example.above.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.above.service.IndexService;
import com.example.above.vo.ProdVO;

@Controller
public class IndexController {

    @Autowired
    IndexService svc;

    @GetMapping("/")
    public String index(Model model){
        ArrayList<ProdVO> vo = svc.selectProdLIst();
        model.addAttribute("vo", vo);
        return "index";
    }
    
}
