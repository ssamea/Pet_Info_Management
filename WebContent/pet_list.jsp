<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="kpu.club.domain.*,java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<link rel= "stylesheet" type="text/css" href="resources/register.css">
</head>
<body>
 <nav id="topMenu" >
    <ul>
                       <li><a class="menuLink" href="welcom.html">메인 페이지</a></li>
                </ul>
</nav>
<br>
<table>
  <tr><td>아이디</td><td>반려견 이름</td><td>반려견 성별</td><td>품종</td><td>보호자 이름</td><td>핸드폰</td><td>주소</td></tr>
 
  <c:forEach var="vo" items="${petList}" >
  
  <tr>
  <td><a href="MemberServlet?key=update&id=<c:out value="${vo.id}" />" target="_self"><c:out value="${vo.id}" /></a></td>
  <td><c:out value="${vo.pet_name}" /></td>
  <td><c:out value="${vo.pet_sex}" /></td>
  <td><c:out value="${vo.kind}" /></td>
  <td><c:out value="${vo.owner_name}" /></td>
  <td><c:out value="${vo.mobile}" /></td>
  <td><c:out value="${vo.address}" /></td>
  <td><a href="MemberServlet?key=delete&id=<c:out value="${vo.id}" />" target="_self">삭제</a></td>
  </tr>
  
  </c:forEach>
</table>
</body>
</html>