package com.example.above.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //언더바 오류로 인한 어노테이션
public class PayinfoVO {
    int payNum;
    int paid_amount;
    String imp_uid;
    
}
