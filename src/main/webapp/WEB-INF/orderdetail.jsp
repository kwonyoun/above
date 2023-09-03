<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
</head>
<jsp:include page="/header"/>
<body>
<div style="width: 1080px; margin: 100px auto;" >

	<!-- ${vo.ordProdNum} -->

	<div class="wrap">
		<div class="wrap2">
			<div class="status">${vo.ordDate}주문</div>
			<div class="wrap3">
				<span class="ord">주문 상세보기</span>
				<svg width="16" height="16" focusable="false" viewBox="0 0 16 16" aria-hidden="true" role="presentation" style="fill:#346aff;vertical-align:middle;height:100%">
					
				</svg>
			</div>
		</div>
		<div>
			<table>
				<colgroup>
					<col width="600"><col width="">
				</colgroup>
				<tbody>
					<tr>
						<td>
							<div>
								<div>
									<span font-weight="bold" color="#111111" style="font-size:1.25rem" class="sc-755zt3-0 hullgd">배송완료</span>
									<span size="4" class="sc-13xhsmd-0 SWzAJ">
										<span size="4" class="sc-13xhsmd-1 kMeFyN"></span>
									</span>
									<span font-weight="normal" color="#555555" class="sc-755zt3-0 sc-lcvccu-0 eDgzyT dhoCVo">8/8(화) 도착</span>
								</div>
							</div>
							<div class="sc-1jiyjbz-0 dGiGeF">
								<div class="sc-gnmni8-9 kCcQTc">
									<div class="sc-9cwg9-1 gLgexz">
										<div class="sc-9cwg9-2 cNiGzR">
											<div class="sc-9cwg9-3 eEDOvs">
												
													<img loading="lazy" width="64" height="64" src="https://cdn-pro-web-218-157.cdn-nhncommerce.com/aomg1266_godomall_com/data/goods/23/04/14/1000000790/1000000790_detail_089.jpg" alt="F.T.M HOODIE black"></a>
												</div>
												<div class="sc-9cwg9-5 bmwSdh">
													<div class="sc-9cwg9-6 jBCCpd">
															<span color="#111111" class="sc-755zt3-1 sc-8q24ha-1 inmgHC ifMZxv">${vo.ordProdNum}</span>
														<a class="sc-gnmni8-10 sc-8q24ha-5 yma-DD iDQVMP">
															<div class="sc-8q24ha-3 gFbjJh">
																<div class="sc-uaa4l4-0 jxRaeI">
																	<span font-weight="normal" class="sc-755zt3-0 kftgZM">${vo.paid_amount}원</span>
																	<span class="sc-13xhsmd-0 kYtEGM"><span class="sc-13xhsmd-1 joIhoV"></span>
																</span><span class="sc-755zt3-0 jtWNEg">1 개</span>
															</div>
														</div>
														<div class="sc-8q24ha-4 cUFnye">
															<button class="sc-1k9quwu-0 iCTfhh sc-xuyxga-0 bZaQeF">장바구니 담기</button>
														</div>
													</a>
												</div>
											</div>
										</div>
									</div></div></div></td>
									<td class="sc-gnmni8-6 gbTJl">
										<div class="sc-gnmni8-7 bCQoer">
											<button class="sc-1k9quwu-0 fUUUKW sc-4d0nwb-0 iiEWkt">배송조회</button>
											<button class="sc-1k9quwu-0 fTrGbC sc-gnmni8-8 kiiuoA">교환, 반품 신청</button>
											<button class="sc-1k9quwu-0 fTrGbC sc-gnmni8-8 kiiuoA">리뷰 작성하기</button>
											<button class="sc-1k9quwu-0 fTrGbC sc-gnmni8-8 kiiuoA">판매자 문의</button>
										</div>
									</td>
									</tr>
									</tbody>
									</table>
									</div>
									<div class="sc-h20x0n-0 gcWEbw"></div>
								</div>
</div>

</body>
<jsp:include page="footer.jsp" />
</html>