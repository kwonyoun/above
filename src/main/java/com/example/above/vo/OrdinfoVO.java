package com.example.above.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// @Data
// @AllArgsConstructor
@Getter
@Setter
public class OrdinfoVO {

    private int ordNum;
    private String memId;
    private int paidAmount;
    private String impUid;
    private String buyerName;
    private String buyerMobile;
    private String buyerAddr;
    private String buyerEmail;
    private String ordAsk;
    private String ordDate;
    // private String ordCard;
    private String ordProdNum;
    private int ordQuan;
    
    private String prodImg;
    //inner join으로 select하려고 OrdinfoVO에 string만들었는데 이거때문에 배열 오류났음.
    //그러면 주문내역에서 prodImg는 어떻게 가져와야 될까?
    //@Data 어노테이션 대신 @Getter. @Setter 로 썻더니 된다.
    //@Data 어노테이션을 지양해야한다.
    //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor을 모두 포함하는 강력한 어노테이션
}
