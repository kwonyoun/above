package com.example.above.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.PayDao;
import com.example.above.vo.OrdinfoVO;
import com.example.above.vo.PayinfoVO;

@Service
public class PayService {

    @Autowired
    PayDao dao;

    //Service
    public void paySuccess(Map<String, Object> map){
        dao.paySuccess(map);
    };

    public OrdinfoVO payInfoSelect(String uid){
        System.out.println("svc");
        OrdinfoVO vo = dao.payInfoSelect(uid);
        System.out.println("vo"+vo);
        return vo;
    };
    
}
