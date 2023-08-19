package com.example.above.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.MemService;
import com.example.above.vo.MemVO;

@Controller
public class MemController {

    @Autowired
    MemService memService;

    @GetMapping("/signup")
    public String member() {
        return "signup";
    }
    //getmapping은 값을 url로 받는 것, 그래서 보안에 약하다는데
    //postmapping은 값을 body로 받는덴다. 
    @PostMapping("/signup")
    public String signup(@ModelAttribute MemVO member) {
        member.setMemAddr(member.getMemAddr1()+"/"+member.getMemAddr2()+"/"+member.getMemAddr3()+"/"+member.getMemAddr4());
        member.setMemBirth(member.getMemBirth1()+"/"+member.getMemBirth2()+"/"+member.getMemBirth3());
        member.setMemMobile(member.getMemMobile0()+"/"+member.getMemMobile1()+"/"+member.getMemMobile2()+"/"+member.getMemMobile3());
        member.setMemEmail(member.getMemEmail1()+"/@"+member.getMemEmail2());
        Integer mem = memService.insertSignup(member);
        System.out.println(mem);
        return "login";
    }

    @GetMapping("/signup/userId/check")
    public Integer signupidcheck(@RequestParam("memId") String id) {

        System.out.println("idcheck   "+id);

        Integer cnt = memService.selectIdCheck(id);
        System.out.println("resultCount   "+cnt);

        return cnt;
    }
    
}
