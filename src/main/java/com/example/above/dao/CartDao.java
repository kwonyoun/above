package com.example.above.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.MemVO;
import com.example.above.vo.ProdVO;

@Mapper
public interface CartDao {

    public MemVO selectMeminfo(String id);
    public ProdVO selectOrdProd(int prodnum);
    
}
