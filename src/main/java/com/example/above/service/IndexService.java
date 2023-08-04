package com.example.above.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.IndexDao;
import com.example.above.vo.ProdVO;

@Service
public class IndexService {

    @Autowired
    IndexDao dao;

    //index페이지 상품selectList
    public ArrayList<ProdVO> selectProdLIst() {
        ArrayList<ProdVO> vo = dao.selectProdLIst();
        return vo;
    }
    
}
