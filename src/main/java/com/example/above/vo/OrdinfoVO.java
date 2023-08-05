package com.example.above.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrdinfoVO {

    private int payNum;
    private String pg;
    private String pay_method;
    private String name;
    private String imp_uid;
    private String merchant_uid;
    private int paid_amount;
    private String apply_num;
    private String buyer_email;
    private String buyer_name;
    private String buyer_tel;
    private String buyer_addr;
    private String ord_ask;
    private String ord_date;
    

}
