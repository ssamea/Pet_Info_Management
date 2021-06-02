<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="kpu.club.domain.*,java.util.List,kpu.club.persistence.*"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/JinSungMin_reg/MemberServlet?key=delete" method="post">
<fieldset>
<ul>
    <li>PET_ID : <input type="text" name="id" value=${pet.id }> </li>
    <%-- <li>PETNAME : <input type="text" name="id" value=${pet.pet_name }> </li>
    <li>PETSEX : <input type="text" name="id" value=${pet.pet_sex }> </li>
    <li>KIND : <input type="text" name="id" value=${pet.kind }> </li>
    <li>OWNERNAME : <input type="text" name="id" value=${pet.owner_name }> </li>
    <li>MOBILE : <input type="text" name="id" value=${pet.mobile }> </li>
    <li>ADDRESS : <input type="text" name="id" value=${pet.address }> </li>
     --%>   </ul>
</fieldset>
<br>

<fieldset>
<input type="submit" name="submit" value="삭제 하기">
  <input type="reset" name="reset" value="다시 작성">
</fieldset>
</form>

</body>
</html>