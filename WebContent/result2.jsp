<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<link rel= "stylesheet" type="text/css" href="resources/register.css">
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav id="topMenu" >
                <ul>
                        <li><a class="menuLink" href="welcom.html">메인 페이지</a></li>
                        <li><a class="menuLink" href="http://localhost:8080/JinSungMin_reg/MemberServlet?key=list">반려 동물 목록</a></li>
                </ul>
</nav>
<p id=sect><%=request.getAttribute("message") %><br>
</body>
</html>