package com.example.above.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.IndexDao;
import com.example.above.dao.MypageDao;
import com.example.above.vo.OrdinfoVO;
import com.example.above.vo.ProdVO;

@Service
public class MypageService {

    @Autowired
    MypageDao dao;

    //index페이지 상품selectList
    public ArrayList<String> selectOrdLIst(String id) {
        ArrayList<String> vo = dao.selectOrdLIst(id);
        return vo;
    }

    //주문정보 select
    public OrdinfoVO selectOrdinfo(HashMap<String, Object> map) {
        OrdinfoVO vo = dao.selectOrdinfo(map);
        return vo;
    }
    
}
