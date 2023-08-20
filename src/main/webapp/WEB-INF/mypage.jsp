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
<jsp:include page="header.jsp"/>
<body>
<div style="width: 1080px; margin: 0 auto;" >

	<c:forEach var="vo" items="${ordlist}" varStatus="status">
		<div style="margin: 10px 10px;" >
			
				<c:out value="${status.count}" />
			<a href="/ordDetail?num=${vo.imp_uid}">${vo.imp_uid}</a> <br>
		
		</div>
	</c:forEach>
</div>

</body>
<jsp:include page="footer.jsp" />
</html>