<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑 제품 상세 페이지</title>
<link rel="stylesheet" type="text/css" href="css/prodView.css">

</head> 
<jsp:include page="header.jsp" />
<body>

<section>

<div id="s_order_wrap" >
	<div class="s_prod_wrap">
	
		<div class="img_wrap">
			<div id="s_prod_detail_img_wrap" >
			
				<div class="s_prod_detail_img" >
					<img style="width: 100px; height: 100px;" src="imgs/${vo.prodImg}">
				</div>
				

				
				<div class="s_prod_detail_img" >
					<img style="width: 100px; height: 100px;"src="imgs/${vo.prodImg2}" >
				</div>

				
			</div>
			
			<div id="s_prod_big_img" >
				<img style="width: 500px; height: 500px;" src="imgs/${vo.prodImg}">
				<div id="square"></div>
			</div>
		</div>
		
		<div class="prod_info_wrap" >
		
			<div class="info_heading_wrap" >
				 
				<h2><input class="input-border-none" id="prod_name" name="prod_name" value="${vo.prodName}" readonly="readonly" > </h2>
				
				<div class="info_heading_desc" style="font-style: inherit; font-size: smaller;" ></div>
		
			</div>
			
			
			
			<form action="/cart" id ="myForm" method="post" >  

				<% String memid = (String)session.getAttribute("id"); %>
			
				
				<input type="hidden" name = "cartProdNum" value = "${vo.prodNum}">
				<input type="hidden" name = "cartMemId" value = "<%=memid%>" >
			
			<table>
				<tr>
					<th><%= "&#8361;" %></th>
					
					<td>
						<span>
							<input class="input-border-none" id="prod_price" name="cartProdPri" value="${vo.prodPrice}" readonly="readonly" >
						</span>
					</td>
					
				</tr>
			</table>

			<div class="total_prod_wrap">
			
				<p id="prod_name2" ></p>
				
				<div id="quantity_wrap">
				
					<input type="text" id="quantity" class="qunt_up" name="cartProdQaun" value="1" min="1">
					
						<div id="count_btn_wrap" >
							<a href="#" onclick="increaseQuantity(event)">
							  <img src="/img/btn_count_up.gif">
							</a>
							
							<a href="#" onclick="decreaseQuantity(event)">
							  <img src="/img/btn_count_down.gif">
							</a>

						</div>
				</div>
			</div>

			<div class="total_price_wrap">
				<div id="total_price">
				
					<input class="input-border-none" id="prod_total_price" name="prodTotalPrice" value="TOTAL" readonly="readonly" > 
				</div>
			</div>

		
			<div class="prod_button" >

					<div id="modal" style="display: none;">
					  <p>장바구니에 추가하였습니다.</p>
					  <button onclick="closeModal()">쇼핑 계속하기</button>
					  <button onclick="goToCart()">장바구니로 이동</button>
					</div>

				<a onclick="payfunction()" class="prod_buy" >구매하기</a>

				
			</div>
			</form>
			

				</div>
					
				</div>		
		
		</div>
		
	</div>

</div>



</section>


</body>

<jsp:include page="footer.jsp" />			
				
</html>