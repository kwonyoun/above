package com.example.above.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.above.service.PayService;
import com.example.above.vo.OrdinfoVO;
import com.example.above.vo.PayinfoVO;
// import com.google.gson.JsonObject;

import jakarta.servlet.http.HttpSession;

@Controller
public class PayController {

    @Autowired
    PayService svc;

    @GetMapping("/pay")
    public String pay() {
        return "pay";
    }

    @ResponseBody
	@RequestMapping(value="/paySuccess", method=RequestMethod.POST)
	public String paySuccess(@RequestBody HashMap<String, Object> map,HttpSession session) {

        //test
        System.out.println("paySuccess");
        System.out.println(map.get("memId"));
        
        // String id = (String) session.getAttribute("Username");
        // map.put("memId", id);

        // 현재 날짜/시간
        LocalDateTime now = LocalDateTime.now();
        String ordDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        map.put("ordDate", ordDate);

        String ordProdNum = map.get("ordProdNum").toString();
        System.out.println("name:"+ordProdNum);

        //return값으로 고유 uid를 반환하기
        //예시
        String imp_uid = map.get("imp_uid").toString();
        String paid_amount = map.get("paid_amount").toString();
        String buyerEmail = map.get("buyerEmail").toString();
        String buyerName = map.get("buyerName").toString();
        String buyerMobile = map.get("buyerMobile").toString();
        String buyerAddr = map.get("buyerAddr").toString();

        System.out.println(map);
        svc.paySuccess(map);

        return imp_uid;
	}

    @GetMapping("/payInfo/{res}")
    public String payInfo(@PathVariable("res") String uid, Model model){
        System.out.println("payInfo");

        OrdinfoVO vo = svc.payInfoSelect(uid);
        model.addAttribute("vo", vo);

        return "paySuccess";

    }

    
}
