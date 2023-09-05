package com.example.above.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.MypageService;
import com.example.above.vo.OrdinfoVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MypageController {

    @Autowired
    MypageService svc;

    @GetMapping("/myPage")
    public String index(@AuthenticationPrincipal UserDetails user,Model model){
        // String id = (String) session.getAttribute("name");
        String id = user.getUsername();
        System.out.println("mypage: "+id);
        ArrayList<String> ordlist = svc.selectOrdLIst(id);
        
        model.addAttribute("ordlist", ordlist);
        return "mypage";
    }

    @GetMapping("/ordDetail")
    public String selectOrdDetail(Model model, @AuthenticationPrincipal UserDetails user, @RequestParam("no") String imp_uid ) {
        // String id = (String) session.getAttribute("id");
        String id = user.getUsername();
        System.out.println(imp_uid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("memId", id);
        map.put("impUid", imp_uid);

        OrdinfoVO vo = svc.selectOrdinfo(map);
        System.out.println(map);
        System.out.println("vo: "+vo);

        model.addAttribute("vo", vo);
        return "orderdetail";
    } 
    
}
