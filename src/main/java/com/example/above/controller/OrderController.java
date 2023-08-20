package com.example.above.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.OrderService;
import com.example.above.vo.MemVO;
import com.example.above.vo.OrdinfoVO;
import com.example.above.vo.ProdVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    OrderService svc;

    @GetMapping("/order")
    public String selectOrdMem(Model model, HttpSession session, @RequestParam("prodNum") int prodNum,@RequestParam("cnt") int cnt ) {
        String id = (String) session.getAttribute("id");
        System.out.println("prodNum: "+prodNum);
        System.out.println("cnt: "+cnt);

        MemVO memVO = svc.selectMeminfo(id);

        String mb =memVO.getMemMobile();
        String[] mobile = mb.split("/");
        memVO.setMemMobile1(mobile[1]);
        memVO.setMemMobile2(mobile[2]);
        memVO.setMemMobile3(mobile[3]);

        String ad = memVO.getMemAddr();
        String [] addr = ad.split("/");
        memVO.setMemAddr1(addr[0]);
        memVO.setMemAddr2(addr[1]);
        memVO.setMemAddr3(addr[2]);
        memVO.setMemAddr4(addr[3]);

        ProdVO ProdVO = svc.selectOrdProd(prodNum);

        model.addAttribute("memVO", memVO);
        model.addAttribute("ProdVO", ProdVO);
        model.addAttribute("ordCnt", cnt);
        return "prodOrder";
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
