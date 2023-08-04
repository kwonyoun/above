package com.example.above.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.ProdVO;

@Mapper
public interface ProdDao {

    public ProdVO selectProd(int prodnum);
    
}
