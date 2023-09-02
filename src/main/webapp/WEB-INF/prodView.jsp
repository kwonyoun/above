<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑 제품 상세 페이지</title>
<link rel="stylesheet" type="text/css" href="/css/prodView.css">
<link rel="stylesheet" type="text/css" href="/css/cart.css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/cart.js"></script>


</head> 
<jsp:include page="header.jsp" />

<body>

<section>

<div id="content" >
	<div id="wrap">

		<section id="sliderType01">
			<div class="slider__wrap">
				<div class="slider__img">
					<div class="slider__btn">
						<a href="#" class="prev" role="button" aria-label="왼쪽 이미지"><</a>
						<a href="#" class="next" role="button" aria-label="오른쪽 이미지">></a>
					</div>
					<div class="slider__inner">
						<div class="slider" role="group" aria-label="1/9">
							<img style="width: 500px; height: 500px;" src="imgs/${vo.prodImg}" alt="이미지1" />
						</div>
						<div class="slider" role="group" aria-label="2/9">
							<img style="width: 500px; height: 500px;" src="imgs/${vo.prodImg}" alt="이미지2" />
						</div>
						<div class="slider" role="group" aria-label="3/9">
							<img  style="width: 500px; height: 500px;"src="imgs/${vo.prodImg}" alt="이미지3" />
						</div>
						<!-- <div class="slider" role="group" aria-label="4/9">
							<img src="../assets/img/effect_img03.jpg" alt="이미지4" />
						</div>
						<div class="slider" role="group" aria-label="5/9">
							<img src="../assets/img/effect_img07.jpg" alt="이미지5" />
						</div>
						<div class="slider" role="group" aria-label="6/9">
							<img src="../assets/img/effect_img08.jpg" alt="이미지6" />
						</div>
						<div class="slider" role="group" aria-label="7/9">
							<img src="../assets/img/effect_img01.jpg" alt="이미지7" />
						</div>
						<div class="slider" role="group" aria-label="8/9">
							<img src="../assets/img/effect_img10.jpg" alt="이미지8" />
						</div>
						<div class="slider" role="group" aria-label="9/9">
							<img src="../assets/img/effect_img05.jpg" alt="이미지9" />
						</div> -->
					</div>
				</div>
				
			</div>
		</section>
		<script src="/js/prodView.js"></script>

		<section id="right" >
			<div class="prod-wrap" >
				<div class="prod-info" >
					<div id="prod-name" ><p>${vo.prodName}</p> </div>
					<div id="prod-price"><p>${vo.prodPrice}</p> </div>
					<div id="prod-content"><p>${vo.prodContent}</p> </div>
				

				<div class="subdiv">
					<div class="basketprice"><input type="hidden" name="p_price" id="p_price1" class="p_price" value="${vo.prodPrice}"></div>
					<div class="num">
						<div class="updown">
							<input type="hidden" id="memid" value="${pageContext.request.userPrincipal.name}" />
							<input type="text" id="quantity" value="1" />
							<button class="plus_btn" value="up">+</button>
							<button class="minus_btn" value="down" >-</button>
						</div>
						<script>
							/* 수량버튼 */
							$(".plus_btn").on("click", function(){
								let quantity = ++(document.getElementById("quantity").value);
								quantity=document.getElementById("quantity").innerText;
							});
						
							$(".minus_btn").on("click", function(){
								let quantityElement = document.getElementById("quantity");
								let quantity = parseInt(quantityElement.value);

								if (quantity > 1) {
									quantity--;
									quantityElement.value = quantity;
								}
							});

							$(".plus_btn, .minus_btn").on("click", function(){
								let quantityElement = document.getElementById("quantity");
								let prodNum = "${vo.prodNum}";
								let quantity = quantityElement.value;
							});

							function sendOrder(prodNum) {
								let quantityElement = document.getElementById("quantity");
								let memid = document.getElementById("memid").value;
								alert(memid);
								let quantity = quantityElement.value;

								window.location.href = "/order?prodNum="+prodNum+"&cnt="+quantity+"&memid="+memid;
							}

						</script>
					</div>
					<!-- <div class="sum">${vo.prodPrice}원</div> -->
					<div id="button-wrap" style="margin-top: 20px;" >
						<div class="buttons" >
							<button><a href="/cartInsert?prodNum=${vo.prodNum}">add to bag</a></button>
							<a id="orderLink" onclick="sendOrder('${vo.prodNum}')" href="#" style="margin-left: 30px; font-size: 1.2em;" >order</a>
		
						</div>
					</div>
				</div>

			</div>	

			</div>
			
			


		</section>

		
		

	</div>	
</div>

</section>

</body>

<jsp:include page="footer.jsp" />	
				
</html>