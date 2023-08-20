package com.example.above.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.above.service.MypageService;
import com.example.above.vo.OrdinfoVO;

@Controller
public class MypageController {

    @Autowired
    MypageService svc;

    @GetMapping("/myPage")
    public String index(Model model){
        ArrayList<String> ordlist = svc.selectOrdLIst();
        model.addAttribute("ordlist", ordlist);
        return "mypage";
    }
    
}
