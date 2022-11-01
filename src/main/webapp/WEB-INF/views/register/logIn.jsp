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
		<h1>로그인 페이지</h1>
			<form action="/register/checkid" method="post">
			<table border="0" align="center" width='500' >
				<tr>
					<th>유저아이디</th>
					<td><input type="text" name="userId">
					</td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="passWd">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">&nbsp;&nbsp;
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
