package com.example.above.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
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

    // @GetMapping("/index")
    // public String indexLogin(@AuthenticationPrincipal User user, Model model){
    //     ArrayList<ProdVO> vo = svc.selectProdLIst();
    //     model.addAttribute("loginId", user.getUsername());
    //     model.addAttribute("loginRoles", user.getAuthorities());
    //     model.addAttribute("vo", vo);
    //     return "index";
    // }
    
}
