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
    // private String ordCard;
    private String ordProdNum;
    private int ordQuan;
    
    // private String prodImg;
    //inner join으로 select하려고 OrdinfoVO에 string만들었는데 이거때문에 배열 오류났음.
    //그러면 주문내역에서 prodImg는 어떻게 가져와야 될까?
}
