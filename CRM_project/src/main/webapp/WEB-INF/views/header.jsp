<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.5/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"/>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.11.5/datatables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="./ckeditor/ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
</head>
<%@include file="./sidebar.jsp" %>
<%@include file="./footer.jsp" %>
  <style>
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .row.content {height: 450px}
    
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
    .container-fluid{
      height: 100px;
    }
    
    #myNavbar{
      margin-top: 20px;	
      font-size: 18px;
    }
    
    body{
    margin-left: 60px;
    background-color: #8b5f5f";
    }
  </style>
</head>
<body>
<%-- <%@include file="./sidebar.jsp" %> --%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header" id="myNavbar">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">

      <ul class="nav navbar-nav navbar-center">
      <li><img style="width:400px; height: 100px; margin-top: -20px; margin-left:400px; text-align: center;" src="./resources/img/black_logo.png"></li>

      </ul>
      <ul class="nav navbar-nav navbar-center">
      <li><img style="width:400px; height: 100px; margin-top: -20px; margin-left:400px;" src="./resources/img/black_logo.png"></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
		      <c:set var="id" value="${id}"/>
		       <c:if test="${fn:substring(id, 0, 3) eq 'SYS'}">	

		         <li style="color:#dbdbdb; margin-top: 15px; margin-right: 15px;">${id} : [시스템 관리자]	</li>
		       </c:if>
		       <c:if test="${fn:substring(id, 0, 3) eq 'CAD'}">	
		         <li style="color: #dbdbdb; margin-top: 15px; margin-right: 15px;">${id} : [거래처 관리자]	</li>
		       </c:if>
      		   <c:if test="${fn:substring(id, 0, 3) eq 'IAD'}">	
		         <li style="color: #dbdbdb; margin-top: 15px; margin-right: 15px;">${id} : [재고 관리자]	</li>

		       </c:if>
      	
        <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>


</body>
</html>

