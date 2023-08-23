package com.example.above.vo;

import lombok.Data;

//@Data로 설정하면 getter/setter가 눈에 보이진않지만 설정된 것임. 
@Data
public class CartVO {
    private int cartNum;
    private String memId;
    private int prodNum;
    private int cartCnt;
    
    
}
