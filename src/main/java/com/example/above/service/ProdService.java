package com.example.above.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.ProdDao;
import com.example.above.vo.ProdVO;

@Service
public class ProdService {

    @Autowired
    ProdDao dao;

    //index페이지 상품selectOne
    public ProdVO selectProd(int prodnum) {
        ProdVO vo = dao.selectProd(prodnum);
        return vo;
    }

    //index페이지 헤더 메뉴
    public ArrayList<ProdVO> selectProdCategory(int ctnum) {
        ArrayList<ProdVO> vo = dao.selectProdCategory(ctnum);
        return vo;
    }
    
}
