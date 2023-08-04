package com.example.above.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.above.dao.UserDao;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    //Service
    public void paid(Map<String, Object> map) {
        userDao.paid(map);
    }

    public void rePaid(Map<String, Object> map) {
        userDao.rePaid(map);		
    }

    public String paidCheck(String ID) {
        return userDao.paidCheck(ID);
    }  
    
}
