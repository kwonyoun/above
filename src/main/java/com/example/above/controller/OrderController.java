package com.example.above.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.above.service.OrderService;
import com.example.above.vo.MemVO;
import com.example.above.vo.ProdVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    OrderService svc;

    @GetMapping("/order")
    public String selectOrdMem(Model model, HttpSession session, @RequestParam("prodNum") int prodNum ) {
        String id = (String) session.getAttribute("id");
        System.out.println("prodNum: "+prodNum);

        MemVO memVO = svc.selectMeminfo(id);

        String mb =memVO.getMemMobile();
        String[] mobile = mb.split("/");
        memVO.setMemMobile1(mobile[0]);
        memVO.setMemMobile2(mobile[1]);
        memVO.setMemMobile3(mobile[2]);

        String ad = memVO.getMemAddr();
        String [] addr = ad.split("/");
        memVO.setMemAddr1(addr[0]);
        memVO.setMemAddr2(addr[1]);
        memVO.setMemAddr3(addr[2]);
        memVO.setMemAddr4(addr[3]);

        ProdVO ProdVO = svc.selectOrdProd(prodNum);

        model.addAttribute("memVO", memVO);
        model.addAttribute("ProdVO", ProdVO);
        // model.addAttribute("ordQuan", quan);
        return "prodOrder";
    }    
    
}
