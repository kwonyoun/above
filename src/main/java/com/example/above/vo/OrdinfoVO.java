package com.example.above.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdinfoVO {

    private int ordNum;
    private String memId;
    private int paid_amount;
    private String imp_uid;
    private String buyerName;
    private String buyerMobile;
    private String buyerAddr;
    private String buyerEmail;
    private String ordAsk;
    private String ordDate;
    private String ordCard;
    private String ordProdNum;
}
