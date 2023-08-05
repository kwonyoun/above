<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>above</title>
   
   <link rel="stylesheet" type="text/css" href="css/header_footer.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
  <!-- <script src="js/header_menu.js"></script> -->

</head>
   <div id="header" >

      <div id="headerwrap" >

         <div id="header-left" >
            <ul>
               <li>luggage</li>
               <li>bags</li>
               <li>goods</li>
               <li>outlet</li>
            </ul>
         </div>

         <div id="logowrap" >
            <a href="/"><img src="/imgs/bully.jpg" ></a>
         </div>

         <% String memid = (String)session.getAttribute("id"); 

         if(memid == null)
         { %>
         <div id="header-right" >
            <ul>
               <li><a href="/login">로그인</a></li>
               <li><a href="/signup">회원가입</a></li>
               <li><a href="/cscenter">고객센터</a></li>
            </ul>
         </div>
         <% } else if(memid != null) { %>
         <div id="header-right" >
            <ul>
               <li><a href="/logout">로그아웃</a></li>
               <li><a href="/signup">myPage</a></li>
               <li><a href="/cscenter">고객센터</a></li>
            </ul>
         </div> 
         <% } %>
      </div>
   </div>
</html>