package com.example.above.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.CartVO;
import com.example.above.vo.ProdVO;

@Mapper
public interface CartDao {

    public ArrayList<ProdVO> selectCartList(String id);
    public void insertCart(CartVO vo);
    
}
