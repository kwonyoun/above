
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot Index</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
<link rel="stylesheet" type="text/css" href="/css/header_footer.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
   <script src="js/slick-1.8.1/slick/slick.min.js"></script>
  <script src="js/header_menu.js"></script>
<script src="js/shopping_bn.js"></script>

</head>

<jsp:include page="header.jsp"/>
<!-- <Script language="JavaScript">
	window.open('URL', 'Name', 'Width=0, Height=0, Top=0, Left=0, Toolbar=yes, Menubar=yes, Statusbar=yes, Scrollbar=yes, Resizable=yes');
	</Script> -->

<body>
	<div style="width: 1080px; margin: 0 auto;" >
		<iframe width="560" height="315" src="https://www.youtube.com/embed/G5Xg_frrEks" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
		<div><p>권윤진</p></div>
	</div>

<div id="wrap">
	<div id="content" >
		
		<div id="prod-wrap" >
			
			<ul class="prod">
				<c:forEach var="vo" items="${vo}">
					<li>
						<a href="/prod?prodNum=${vo.prodNum}">
							<img style="width: 240px; height: 240px;" src="/imgs/${vo.prodImg}">
						</a>
						<div style="width: 240px;" >${vo.prodName}</div>
					</li>
				</c:forEach>
			</ul>
			
				
		</div>
		
	</div>
</div>


    
</body>
<jsp:include page="footer.jsp" />
</html>