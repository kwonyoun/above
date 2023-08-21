package com.example.above.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String index(HttpSession session,Model model){
        String id = (String) session.getAttribute("id");
        ArrayList<String> ordlist = svc.selectOrdLIst(id);
        
        model.addAttribute("ordlist", ordlist);
        return "mypage";
    }

    @GetMapping("/ordDetail")
    public String selectOrdDetail(Model model, HttpSession session, @RequestParam("num") String imp_uid ) {
        String id = (String) session.getAttribute("id");

        HashMap<String, Object> map = new HashMap<>();
        map.put("memId", id);
        map.put("imp_uid", imp_uid);

        OrdinfoVO vo = svc.selectOrdinfo(map);

        model.addAttribute("vo", vo);
        return "orderdetail";
    } 
    
}
