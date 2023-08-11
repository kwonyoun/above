package com.example.above.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.CartDao;
import com.example.above.vo.CartVO;
import com.example.above.vo.ProdVO;

@Service
public class CartService {

    @Autowired
    CartDao dao;

    //주문 상품정보 select
    public ArrayList<ProdVO> selectCartList(String id) {
        ArrayList<ProdVO> vo = dao.selectCartList(id);
        return vo;
    }

    //장바구니 insert
    public void insertCart(CartVO vo){
        System.out.println("svc");
        dao.insertCart(vo);
    }

    //장바구니 delete
    public void deleteCart(int num){
        dao.deleteCart(num);
    }
    
}
