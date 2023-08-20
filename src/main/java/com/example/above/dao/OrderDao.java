package com.example.above.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.MemVO;
import com.example.above.vo.OrdinfoVO;
import com.example.above.vo.ProdVO;

@Mapper
public interface OrderDao {

    public MemVO selectMeminfo(String id);
    public ProdVO selectOrdProd(int prodnum);
    public OrdinfoVO selectOrdinfo(HashMap<String, Object> map);
    
    
}
