// function requestPay() {
//     IMP.init('imp71853610'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
//     IMP.request_pay({
//         pg: "INIpayTest",
//         pay_method: "card",
//         merchant_uid : 'merchant_'+new Date().getTime(),
//         name : '결제테스트',
//         amount : 100,
//         buyer_email : 'iamport@siot.do',
//         buyer_name : '구매자',
//         buyer_tel : '010-1234-5678',
//         buyer_addr : '서울특별시 강남구 삼성동',
//         buyer_postcode : '123-456'
//     }, function(data){
//         if(data.success){
//             var msg = "결제 완료";
//             msg += '고유ID : ' + data.imp_uid;                //아임포트 uid는 실제 결제 시 결제 고유번호를 서버와 비교해서 결제처리하는데 필요없긴함.
//             msg += '// 상점 거래ID : ' + data.merchant_uid;
//             msg += '// 결제 금액 : ' + data.paid_amount;
//             msg += '// 카드 승인번호 : ' + data.apply_num;
            
//             $.ajax({
//                 type : 'post',
//                 url : '/paySuccess',
//                 data : {
//                     "imp_uid" : data.imp_uid, 
//                     "paid_amount" : data.paid_amount},
//             });
            
//         }else{
//             var msg = "결제 실패"
//             msg += "에러 내용" + rsp.error_msg;
//         }
//         alert(msg);
//         document.location.href="/unitpay/"+data.imp_uid;
//     });

//     }

function requestPay() {
    IMP.init('imp71853610'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
    var mem_id = document.getElementById("mem_id").value ;
    var buyer_name = document.getElementById("mem_name_input").value ;
    var tel1= document.getElementById("mem_mobile1_input").value;
    var tel2= document.getElementById("mem_mobile2_input").value;
    var tel3= document.getElementById("mem_mobile3_input").value;
    var buyer_tel = tel1+"-"+tel2+"-"+tel3;
    var buyer_postcode = document.getElementById("sample6_postcode").value;
    var addr1 = document.getElementById("sample6_address").value;
    var addr2 = document.getElementById("sample6_detailAddress").value;
    var addr3 = document.getElementById("sample6_extraAddress").value;
    var buyer_addr = buyer_postcode+"/"+addr1+"/"+addr2+"/"+addr3;
    var prodprice = document.getElementById("prodprice").value;
    var ordQuan = document.getElementById("ordcnt").value;
    var prodname = document.getElementById("prodname").value;
    // alert(mem_id);
    alert(ordQuan);

    IMP.request_pay({
        pg: "INIpayTest",
        pay_method: "card",
        merchant_uid : 'merchant_'+new Date().getTime(),
        name : prodname,
        amount : 100, 
        buyer_email : 'iamport@siot.do',
        buyer_name : buyer_name,
        buyer_tel : buyer_tel,
        buyer_addr : buyer_addr
    }, function(data){
        if(data.success){
            var msg = "결제 완료";
            msg += '고유ID : ' + data.imp_uid;                //아임포트 uid는 실제 결제 시 결제 고유번호를 서버와 비교해서 결제처리하는데 필요없긴함.
            msg += '// 상점 거래ID : ' + data.merchant_uid;
            msg += '// 결제 금액 : ' + data.paid_amount;
            msg += '// 카드 승인번호 : ' + data.apply_num;

            var ordData = {
                "ordProdNum" : data.name,
                "imp_uid" : data.imp_uid,
                "merchant_uid" : data.merchant_uid,
                "paid_amount" : data.paid_amount,
                "apply_num" : data.apply_num,
                "buyerEmail" : data.buyer_email,
                "buyerName" : data.buyer_name,
                "buyerMobile" : data.buyer_tel,
                "buyerAddr" : data.buyer_addr,
                "memId" : mem_id,
                "ordQuan" :ordQuan
            };
            
            $.ajax({
                type : 'post',
                url : '/paySuccess',
                contentType: 'application/json; charset=utf-8', 
                data : JSON.stringify(ordData),
                success: function(res) {
                    alert("ajax-success   "+res);
                    document.location.href="/payInfo/"+res;
                    
                },
                error: function(xhr, status, error) {
                    console.error(error);
                    alert("error:"+error);
                }
            });
            alert(msg);
            
        }else{
            var msg = "결제 실패"
            msg += "에러 내용" + rsp.error_msg;
            alert(msg);
            document.location.href="/pay";
        }
        
    });

    }