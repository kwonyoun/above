package com.example.above.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.MemVO;

@Mapper
public interface MemDao {

    public Integer insertSignup(MemVO mem);
    public MemVO selectMem(String loginmem);
    public Integer selectIdCheck(String idcheck);


    
}
