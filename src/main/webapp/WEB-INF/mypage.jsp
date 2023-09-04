<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
<link rel="stylesheet" type="text/css" href="/css/mypage.css">
</head>
<jsp:include page="/header"/>
<body>
<div style="width: 800px; margin: 0 auto;" >

	<!-- <c:forEach var="vo" items="${ordlist}" varStatus="status">
		<div style="margin: 10px 10px; width: 50px; height: 50px;" >
			
				<p style="border-style: solid; border-width: 1px;    border-style: solid;
				border-width: 1px;
				width: 50px;
				height: 50px;
				text-align: center;
				line-height: 50px;
				float: left;" ><c:out value="${status.count}" /></p>
			<a style="float: left; width: 50px;
				height: 50px;
				text-align: center;
				line-height: 50px;" href="/ordDetail?num=${vo.imp_uid}">${vo.imp_uid}</a> <br>
		
		</div>
	</c:forEach> -->
	<div style="width: 800px;" ><p style="text-align: center; font-size: 1.5em;" >주문 내역 확인하기</p></div>
	<div class="scroll-table">
		<div>
			
			<table>
				<caption>주문 목록</caption>
				<colgroup>
					<col width="*">
					<col width="120">
					<col width="120">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">주문 번호</th>
						<th scope="col">주문 일자</th>
					</tr>
				</thead>
							
				<tbody>
					<c:forEach var="vo" items="${ordlist}" varStatus="status">
						<tr>
							<td><c:out value="${status.count}" /></td>
							<td><a href="/ordDetail?no=${vo.imp_uid}">${vo.imp_uid}</a></td>
							<td>${vo.ordDate}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
</div>

</body>
<jsp:include page="/footer" />
</html>