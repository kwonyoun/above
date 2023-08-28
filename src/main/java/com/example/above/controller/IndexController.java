package com.example.above.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.above.service.IndexService;
import com.example.above.vo.MemVO;
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

    @GetMapping("/header")
    public String header(){
        return "header";
    }

    // @GetMapping("/index")
    // public String loginHome(@SessionAttribute(name = "loginMember", required = false) MemVO loginMember)
    // {
    //     return "";
    // }
    
    @GetMapping("/footer")
    public String footer(){
        return "footer";
    }

    // @GetMapping("/index")
    // public String indexLogin(@AuthenticationPrincipal User user, Model model){
    //     ArrayList<ProdVO> vo = svc.selectProdLIst();
    //     model.addAttribute("loginId", user.getUsername());
    //     model.addAttribute("loginRoles", user.getAuthorities());
    //     model.addAttribute("vo", vo);
    //     return "index";
    // }

    //session id보이기
    @RequestMapping("/index")
    public ModelAndView indexSession(ModelAndView mav) {
        ArrayList<ProdVO> vo = svc.selectProdLIst();
        String loginId = SecurityContextHolder.getContext().getAuthentication().getName();
        mav.addObject("loginId", loginId);
        mav.addObject("vo", vo);
        mav.setViewName("index");
        return mav;
    }
    
}
