package com.example.above.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    
    //Dao
    public void paid(Map<String, Object> map) ;

    public void rePaid(Map<String, Object> map) ;

    public String paidCheck(String ID) ;
    
}
