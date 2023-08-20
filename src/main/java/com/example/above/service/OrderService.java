package com.example.above.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.OrderDao;
import com.example.above.vo.MemVO;
import com.example.above.vo.OrdinfoVO;
import com.example.above.vo.ProdVO;

@Service
public class OrderService {

    @Autowired
    OrderDao dao;

    //주문자 정보 select
    public MemVO selectMeminfo(String id) {
        MemVO vo = dao.selectMeminfo(id);
        return vo;
    }

    //주문 상품정보 select
    public ProdVO selectOrdProd(int prodnum) {
        ProdVO vo = dao.selectOrdProd(prodnum);
        return vo;
    }

    //주문정보 select
    public OrdinfoVO selectOrdinfo(HashMap<String, Object> map) {
        OrdinfoVO vo = dao.selectOrdinfo(map);
        return vo;
    }

    

    
    
}
