package com.example.above.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.above.service.CartService;
import com.example.above.vo.CartVO;
import com.example.above.vo.ProdVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

    @Autowired
    CartService svc;

    @GetMapping("/cartInsert")
    public String index(Model model, HttpSession session, @RequestParam("prodNum") int prodNum){
        String id = (String) session.getAttribute("id");
        int cnt = 1;
        
        CartVO vo = new CartVO();
        vo.setMemId(id);
        vo.setProdNum(prodNum);
        vo.setCartCnt(cnt);

        // svc.insertCart(vo);

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cartlist(Model model, HttpSession session){
        String id = (String) session.getAttribute("id");
        ArrayList<ProdVO> cart = svc.selectCartList(id);
        for (int i = 0; i < cart.size(); i++) {
            System.out.println("prodname");
            System.out.println( cart.get(i).getProdName());
        }
        // ModelAndView mav = new ModelAndView();
        // mav.addObject("cartList", cart); 
        // mav.setViewName("/cart");
        
        model.addAttribute("cartList", cart);
        return "cart";
    }
    
}
