<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
<link rel="stylesheet" type="text/css" href="/css/pay.css">
<link rel="stylesheet" type="text/css" href="/css/header_footer.css">
</head>
<jsp:include page="header.jsp"/>

<body>

	<!-- <div class="wrap" style="margin: 0 auto; width: 1080px;" >
	
		<p style="margin: 50px 0; text-align: center; font-size: 1.5em; " >결제가 완료되었습니다.</p>
	
	    <div class="paycontent" style="margin: 0 auto; text-align: center; margin-bottom: 50px; " >
        결제금액: ${vo.paid_amount}
		주소: ${vo.buyerAddr}
		번호: ${vo.buyerMobile}
		이름: ${vo.buyerName}
        
		</div>
	</div> -->

	<div class="container"  style="margin: 0 auto; width: 1080px;  ">
		<h1 style="text-align: center;" >주문하신 상품 결제가 완료되었습니다.</h1>
		<div style="margin: 0 auto; width: 500px; margin-top: 50px; margin-bottom: 50px; "> 
		<div class="panel panel-primary" >
		  <div class="panel-heading">
			<h3 class="panel-title">주문 내역</h3>
		  </div>
		  <div class="panel-body" style="margin-bottom: 20px;" >
			<div class="table-reponsive">
			  <table class="table table-condensed">
				<thead>
				  <tr>
					<th>상품코드</th>
					 <th class="text-center">제품명</th>
					 <th class="text-center">금액</th>
					 <th class="text-center">수량</th>
					 <th class="text-center">최종금액</th>
				  </tr>
				</thead>
				<tbody>
				  <tr>
					<td>BS-200</td>
					<td>DLBP-114</td>
					<td class="text-center">${vo.paid_amount}원</td>
					<td class="text-center">1</td>
					<td class="text-right">${vo.paid_amount}원</td>
				  </tr>
				  <!-- <tr>
					<td>BS-200</td>
					<td>DLBP-114</td>
					<td class="text-center">100,000원</td>
					<td class="text-center">1</td>
					<td class="text-right">100,000원</td>
				  </tr>
				  <tr>
					<td>BS-200</td>
					<td>DLBP-114</td>
					<td class="text-center">100,000원</td>
					<td class="text-center">1</td>
					<td class="text-right">100,000원</td>
				  </tr> -->
				  <tr>
					<td class="thick-line"></td>
					<td class="thick-line"></td>
					<td class="thick-line"></td>
					<td class="thick-line text-center"><strong>합계</strong></td>
					<td class="thick-line text-right">${vo.paid_amount}원</td>
				  </tr>
				 
				</tbody>
			  </table>
			</div>
		  </div>
		</div>
		
		<div class="panel panel-primary" style="margin-bottom: 20px;" >
		  <div class="panel-heading">
			<h3 class="panel-title">결제 정보</h3>
		  </div>
		  <div class="panel-body">
			<div class="table-reponsive">
			  <table class="table table-bordered">
				<tbody>
				  <tr>
					<td class="text-center gr"><strong>주문번호</strong></td>
					<td>${vo.imp_uid}</td>
					<td class="text-center gr"><strong>주문일</strong></td>
					<td>${vo.ordDate}</td>
				  </tr>
				  <tr>
					<td class="text-center gr"><strong>전화번호</strong></td>
					<td>${vo.buyerMobile}</td>
				  </tr>
				  <tr>
					<td class="text-center gr"><strong>결제금액</strong></td>
					<td>${vo.paid_amount}원</td>
					<td class="text-center gr"><strong>결제상태</strong></td>
					<td>결제완료</td>
				  </tr>
				</tbody>
			  </table>
			</div>
		  </div>
		</div>
		<div class="panel panel-primary" style="margin-bottom: 20px;" >
		  <div class="panel-heading">
			<h3 class="panel-title">배송 정보</h3>
		  </div>
		  <div class="panel-body">
			<div class="table-reponsive">
			  <table class="table table-bordered">
				<tbody>
				 <tr>
					<td class="text-center gr w30">받으시는 분</td>
				   <td>${vo.buyerName}</td>
				  </tr>
				  <tr>
					<td class="text-center gr w30">주소</td>
				   <td>${vo.buyerAddr}</td>
				  </tr>
				  <tr>
					<td class="text-center gr w30">휴대폰 번호</td>
				   <td>${vo.buyerMobile}</td>
				  </tr>
				  <tr>
					<td class="text-center gr w30">배송방법</td>
				   <td>택배</td>
				  </tr>
				</tbody>
			  </table>
			</div>
		  </div>
		</div>
	</div>

	<div style="text-align: center; margin-bottom: 30px;" ><button style="margin:0 auto ;" ><a href="/">확인</a></button></div>
	  </div>
	  

</body>
<jsp:include page="footer.jsp" />
</html>

