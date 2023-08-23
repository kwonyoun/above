
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Q&A</title>

    <link rel="stylesheet" href="/css/header_footer.css">
    <link rel="stylesheet" href="/css/css.css">
    <link rel="stylesheet" href="/css/cscenter_qna.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> 
   <style type="text/css">
      
      section .cscenter_menu_wrap .cscenter_menu:first-child, .cscenter_menu:nth-child(2) {
         background-color: #f6f6f6;
         border-radius: 10px; 
         }
      
         section .cscenter_menu_wrap .cscenter_menu:nth-child(3) {
         background-color: rgba(126, 125, 203, 0.26);
         border-radius: 10px;
         }
         
         .cscenter_menu {
         
         position: relative;
      }
      
      .triangle {
      
         margin-left: 165px; /* 삼각형의 가로 길이의 절반 */
         width: 0;
         height: 0;
         border-top: 10px solid rgba(126, 125, 203, 0.26); /* 삼각형의 높이 */
         border-right: 10px solid transparent;
         border-left: 10px solid transparent;
      }
      
   </style>  
    
</head>

<body>

   <jsp:include page="header.jsp" />

<section>
   
   <div class="cscenter" >

         <div class="cscenter_menu_wrap" >
         
               <div class="cscenter_menu" >
               
                  <div class="cscenter_menu_txt">         
                     <p style="margin-left: 30px;"><a href="/csNotice" >공지사항</a></p>
                  </div>   
               
               </div>
               
               <div class="cscenter_menu" >
               
                  <div class="cscenter_menu_txt">         
                     <p><a href="/cscenter">자주하는 질문</a></p>
                  </div>
               
               </div>
               
               <div class="cscenter_menu" >
               
                  <div class="cscenter_menu_txt">         
                     <p><a href="/cscenter/qnalist">직접 문의하기</a></p>

                  </div>
                  
                  <div class="triangle"></div>

               </div>
            
            </div>
                     
      </div>

      
<!-- <form action="cscenter_qna_list_date.jsp"> -->
    <div class="board_wrap">
    
        <div class="qna_title">
         
           <div id="qna_title_wrap" >
               <h1 style="font-size: 40px;" >Q&A</h1>
            <h3 style="font-size: 20px;" >직접 문의하기</h3>
            
         </div>
         
         <!-- <div class="qna_date_wrap" >
                
              <input type="date"  name="start_date" >
            <input type="date" name="end_date" >
            <input type="submit" value="조회하기" >
        
           </div> -->
           <span>총게시물 ${totCnt} / 페이지 (${pagination.currentPageNo} / ${totalPageCnt})</span>

           <div class="bt_wrap" style="float: right; margin-right: 30px;" >
            <a href="/cscenter/qna/write" class="on" >등록</a>
            <!--<a href="#">수정</a>-->
        </div>
        </div>
        
        <div class="board_list_wrap">
            <div class="board_list">
                <div class="top">
                 <!-- <div class="num">번호</div> -->   
                    <div class="num">카테고리</div>
                    <div class="title">제목</div>
                    <div class="writer">질문자</div>
                    <div class="count">답변상황</div>
                    <div class="date">문의일</div>
                </div>

               <div>

                  <!-- foreach 문으로 컬렉션 반복 처리 -->
                  <c:forEach var="item" items="${boardList}">
                     <div class="num">${item.qnaNum} </div>
                     <div class="title">
                        <a href="/cscenter/qna/view?qnaNum=${item.qnaNum}">${item.qnaTitle}
                           <c:if test="${item.qnaOpen eq 'private'}">
                           <img src="/imgs/lock.png" alt="fail" style="width: 12px; height: 12px;" >
                           </c:if>
                        </a>
                     
                     
                     </div>
                     <div class="writer">${item.qnaMemId}</div>
                     <div class="writer">${item.qnaOpen}</div>
                     <div class="date">${item.qnaDate}</div>
                  </c:forEach>

               </div>


               <!-- Paging[s] -->
      <div >
         <div class="col-sm-12 col-md-7" style="display: flex; justify-content: center;">
            <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
               <ul class="pagination" style="display: flex;" >
               
                  <c:if test="${pageVO.prev}">
                     <li class="paginate_button page-item previous" id="dataTable_previous">
                           <a href="javascript:void(0);" onclick="fn_go_page(${pageVO.startDate - 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
                     </li>
                  </c:if>
                     
                  <c:forEach var="num" begin="${pageVO.startDate}" end="${pageVO.endDate}">
                     <li class="paginate_button page-item" style="border-style: solid;border-width: 2px; width: 20px; height: 30px; line-height: 30px;" >
                           <a href="javascript:void(0);" onclick="fn_go_page(${num}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">${num}</a>
                     </li>
                  </c:forEach>
                     
                  <c:if test="${pageVO.next}">
                     <li class="paginate_button page-item next" id="dataTable_next">
                           <a href="javascript:void(0);" onclick="fn_go_page(${pageVO.endDate + 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Next</a>
                     </li>
                  </c:if>
               </ul>
            </div>
         </div>   
      </div>

      <style>
         .paginate_button{
            margin-right: 20px;
         }
      </style>

            <!-- Paging[e] -->
            <form method="get"  id="listForm" action="/cscenter/qnalist/page"  >
               <input type="hidden" id="pageIndex" name="pageIndex" val="" />
            </form>
            <script>
               function fn_go_page(pageNo) {
               $("#pageIndex").val(pageNo);
               $("#listForm").submit();
               return false;
            }
            </script>
                
                
            
         </div>
      </div>

      
     
    
    </section>
    
    <footer>
   <jsp:include page="footer.jsp"/>
   </footer>
   
</body>
</html> 