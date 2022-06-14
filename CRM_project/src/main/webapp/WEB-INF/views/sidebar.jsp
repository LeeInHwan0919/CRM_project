<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"> -->
<link rel="stylesheet" href = "./resources/css/sidebar.css">
<meta charset="UTF-8">
<title>side_bar</title>
</head>
<body>
<aside class="side-bar">
  <div class="side-bar__status-ico">
    <div></div>
    <div></div>
    <div></div>
  </div>
  <nav class="side-bar__Top">
    <ul>
      <li>
         <a href="./boardList.do">
          <span>
            <i class="fas fa-list"></i>
          </span>
          <span>공지 게시판</span>
        </a>
      </li>
      <li>
      <c:set var="id" value="${id}"/>
<%--       <c:if test="${fn:substring(id, 0, 3) eq 'IAD'}"> --%>
        <a href="./GoodsList.do">
          <span>
           <i class="fa-solid fa-trophy"></i>
          </span>
          <span>재고관리</span>
        </a>
<%--         </c:if> --%>
      </li>
      <li>
      <c:set var="id" value="${id}"/>
<%--       <c:if test="${fn:substring(id, 0, 3) eq 'CAD'}"> --%>
         <a href="./clientList.do">
          <span>
              <i class="fa-solid fa-magnifying-glass-plus"></i>
          </span>
          <span>거래처관리</span>
        </a>
<%--       </c:if> --%>
      </li>
      <li>
      <c:set var="id" value="${id}"/>
<%--       <c:if test="${fn:substring(id, 0, 3) eq 'SYS'}"> --%>
          <a href="./UsersList.do">
          <span>
            <i class="fa-solid fa-comment-dots"></i>
          </span>
          <span>계정관리</span>
          </a>
<%--       </c:if> --%>
      </li>
      
      <li>
          <a href="./Backup.do">
          <span>
            <i class="fa-solid fa-comment-dots"></i>
          </span>
          <span>백업</span>
        </a>
      </li>
      <li>
        <a href="./result.do">
          <span>
            <i class="fa-solid fa-house"></i>
          </span>
          <span>메인화면 이동</span>
        </a>
      </li>
    </ul>
  </nav>
</aside>
</body>
</html>