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
			<h1>상새내용 페이지</h1>
			<c:set var="vo" value="${cont }"/>
			<table border="0" align="center" width='500' >
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" name="bdTitle" value="${vo.bdTitle}" readonly>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="bdWriter"value="${vo.bdWriter}" readonly>
					</td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><textarea rows="3" cols="50" name="bdContent"  readonly>${vo.bdContent}</textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="게시글수정" onclick="location.href='/board/modifyBoard?bdNum=${vo.bdNum}'">
						<input type="reset" value="게시글 삭제" onclick="location.href='/board/deleteBoard?bdNum=${vo.bdNum}'">
						<input type="button" value="전체목록" onclick="location.href='/board/indexBoard'">
					</td>
				</tr>
								
			</table>
			
		
		</div>
			
		
	</main>
</section>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
