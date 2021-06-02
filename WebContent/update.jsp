<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="kpu.club.domain.*,java.util.List"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div aligin="center">
<header> Member update</header>
<HR>
<form action="http://localhost:8080/JinSungMin_reg/MemberServlet?key=update" method="post">
  

<fieldset>
 <legend> Personnel Information</legend>
    <ul>
    <li>ID : <input type="text" name="id" value=${pet.id }  readonly="readonly"> </li>
    <li>PET_NAME : <input type="text" name="pet_name" value=${pet.pet_name } > </li>
    <li>PET_SEX : <input type="text" name="pet_sex" value=${pet.pet_sex }> </li>
    <li>KIND : <input type="text" name="kind" value=${pet.kind }> </li>
    <li>OWNER_NAME : <input type="text" name="owner_name" value=${pet.owner_name }> </li>
    <li>MOBILE : <input type="text" name="mobile" value=${pet.mobile }> </li>
    <li>ADDRESS : <input type="text" name="address" value=${pet.address }> </li>
    </ul>
</fieldset>
<br>
<fieldset>
  <input type="submit" name="submit" value="수정하기">
  <input type="reset" name="reset" value="다시 작성">
</fieldset>


</form>
</div>
</body>
</html>