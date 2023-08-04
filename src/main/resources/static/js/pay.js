function requestPay() {
    IMP.init('imp71853610'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
    IMP.request_pay({
        pg: "INIpayTest",
        pay_method: "card",
        merchant_uid : 'merchant_'+new Date().getTime(),
        name : '결제테스트',
        amount : 100,
        buyer_email : 'iamport@siot.do',
        buyer_name : '구매자',
        buyer_tel : '010-1234-5678',
        buyer_addr : '서울특별시 강남구 삼성동',
        buyer_postcode : '123-456'
    }, function(data){
        if(data.success){
            var msg = "결제 완료";
            msg += '고유ID : ' + data.imp_uid;                //아임포트 uid는 실제 결제 시 결제 고유번호를 서버와 비교해서 결제처리하는데 필요없긴함.
            msg += '// 상점 거래ID : ' + data.merchant_uid;
            msg += '// 결제 금액 : ' + data.paid_amount;
            msg += '// 카드 승인번호 : ' + data.apply_num;
            
            $.ajax({
                type : 'post',
                url : '/paySuccess',
                data : {
                    "imp_uid" : data.imp_uid, 
                    "paid_amount" : data.paid_amount},
            });
            
        }else{
            var msg = "결제 실패"
            msg += "에러 내용" + rsp.error_msg;
        }
        alert(msg);
        document.location.href="/unitpay/"+data.imp_uid;
    });

    }