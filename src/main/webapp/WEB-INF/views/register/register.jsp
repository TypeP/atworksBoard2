<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<style type="text/css">
#btn1(border:1)
</style>
	<title>atworks</title>
</head>
<%@ include file="/WEB-INF/views/include/script.jsp" %>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<script>

</script>
 
<section class="main_wrap">
	<main class="main">
		<div align="center" >
			<h1>회원가입 페이지</h1>
			<form action="/register/insert" method="post">
			<table border="0" align="center" width='500' >
				<tr>
					<th>유저아이디</th>
					<td><input type="text" name="userId">
					</td>
				</tr>
				<tr>
					<th>유저이름</th>
					<td><input type="text" name="userNm">
					</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="passWd">
					</td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nick">
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" name="phone">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="회원 등록">&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
								
			</table>
			</form>
		
		</div>
			
		
	</main>
</section>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
