<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>above</title>
   
   <link rel="stylesheet" type="text/css" href="/css/header_footer.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
  <!-- <script src="js/header_menu.js"></script> -->

</head>
   <div id="header" >

      <div id="headerwrap" >

         <div id="header-left" >
            <ul>
               <li><a href="/prod/goods?ct=1">TOP</a></li>
               <li><a href="/prod/goods?ct=2">BOTTOM</a></li>
               <li><a href="/prod/goods?ct=3">ACCESSORY</a></li>
               <li><a href="/prod/goods?ct=4">CAP</a></li>
            </ul>
         </div>
         
         <div id="logowrap" >
            <a href="/"><img src="/imgs/logo.png" ></a>
         </div>     
         
         <c:if test="${pageContext.request.userPrincipal.name == null}" >
         <div id="header-right" >
            <ul>
               <li><a href="/admin" class="nav-link px-2 link-dark">관리자 페이지</a></li>
               <li><a href="/login">로그인</a></li>
               <li><a href="/signup">회원가입</li>
               <li><a href="/cscenter/qnalist">Q&A</a></li>
            </ul>
         </div>
         </c:if>

         <c:if test="${pageContext.request.userPrincipal.name != null}" >
         <div id="header-right" >
            <ul>
               
               <!-- <sec:authorize access="hasRole('ADMIN')">
			         <li><a href="/admin" class="nav-link px-2 link-dark">관리자 페이지</a></li>
		         </sec:authorize> -->
               <sec:authorize access="hasRole('USER')">
                  <li><a href="/myPage">${pageContext.request.userPrincipal.name}의 주문내역 확인</a></li>
               </sec:authorize>
               <li><form method="post" action="/logout">
                  <button class="btn btn-sm btn-danger btn-block" type="submit">로그아웃</button>
               </form></li>                  
               <li><a href="/cscenter/qnalist">Q&A</a></li>
            </ul>
         </div> 
         </c:if>
         
      </div>
   </div>
</html>