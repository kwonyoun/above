package com.example.above.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.OrdinfoVO;

@Mapper
public interface MypageDao {

    public ArrayList<String> selectOrdLIst(String id); 
    public OrdinfoVO selectOrdinfo(HashMap<String, Object> map);  
}
