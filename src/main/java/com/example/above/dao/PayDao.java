package com.example.above.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.above.vo.PayinfoVO;

@Mapper
public interface PayDao {
    
    //Dao
    public void paySuccess(Map<String, Object> map);
    public PayinfoVO payInfoSelect(String uid);
    
}
