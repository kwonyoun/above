package com.example.above.controller;

import java.util.ArrayList;
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
    public String index(Model model, @RequestParam("memid") String id, @RequestParam("prodNum") int prodNum){
        // String id = (String) session.getAttribute("name");
        System.out.println("session"+id);
        int cnt = 1;
        
        CartVO vo = new CartVO();
        vo.setMemId(id);
        vo.setProdNum(prodNum);
        vo.setCartCnt(cnt);

        svc.insertCart(vo);
        
    return "redirect:/cartList?memid="+id;
        
    }

    @GetMapping("/cartList")
    public String cartlist(Model model, @RequestParam("memid") String id){
        // String id = (String) session.getAttribute("id");
        ArrayList<ProdVO> cart = svc.selectCartList(id);

        // ModelAndView mav = new ModelAndView();
        // mav.addObject("cartList", cart); 
        // mav.setViewName("/cart");
        
        model.addAttribute("cartList", cart);
        return "cart";
    }

    @ResponseBody
    @RequestMapping(value = "/cartDelete/{cartNum}" ,method = RequestMethod.POST)
    public String cartDelete(@RequestBody @PathVariable("cartNum") int cartNum){
        svc.deleteCart(cartNum);
        return "cartList";
    }
    
}
