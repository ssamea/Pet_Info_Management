<%@page import="java.util.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="kpu.club.domain.*,java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">
<title>결과 화면</title>
<link rel= "stylesheet" type="text/css" href="resources/register.css">

</head>
<body>

 <nav id="topMenu" >
                <ul>
                        <li><a class="menuLink" href="welcom.html">메인 페이지</a></li>
                        <li><a class="menuLink" href="http://localhost:8080/JinSungMin_reg/MemberServlet?key=list"target="_self">반려 동물 목록 </a></li>
                     
                </ul>
</nav>

<header>반려동물 등록 관리 </header>
<p id=sect><%=request.getAttribute("message") %><br>
<div>
   
<table>
<tr><td>아이디</td><td>반려동물 이름</td><td>반려동물 성별</td><td>품종</td><td>보호자 이름</td><td>핸드폰</td><td>주소</td></tr>

  <tr>
  <td>${param.id}</td>
  <td>${param.pet_name}</td>
  <td>${param.pet_sex}</td>
  <td>${param.kind}</td>
  <td>${param.owner_name}</td>
  <td>${param.mobile}</td>
  <td>${param.address}</td>

  </tr>

 </table>
 </div> 
 
 
</body>
</html>