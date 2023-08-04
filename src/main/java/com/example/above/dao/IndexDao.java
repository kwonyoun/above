package com.example.above.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.ProdVO;

@Mapper
public interface IndexDao {

    public ArrayList<ProdVO> selectProdLIst();
    
}
