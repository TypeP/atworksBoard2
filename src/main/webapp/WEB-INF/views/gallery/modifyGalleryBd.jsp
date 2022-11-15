<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<h1>수정 페이지</h1>
			<c:set var="vo" value="${cont}"/>
			<form action="/gallery/modifyGalleryBoard" method="post" enctype="multipart/form-data" novalidate>
			<input type="hidden" name="bdNum" value="${vo.bdNum }">
			<table border="0" align="center" width='500' >
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" name="bdTitle" value="${vo.bdTitle}" >
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="bdWriter"value="${vo.bdWriter}" >
					</td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><textarea rows="3" cols="50" name="bdContent"  >${vo.bdContent}</textarea>
					</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" multiple="multiple" id="file" name="file" class="form-control"></td>
						
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="게시글수정">
						<input type="reset" value="게시글 리셋" >
					</td>
				</tr>
								
			</table>
			</form>
			<br>
			
			<%-- <table border="0" align="center">
				<tr align="center">
					<th align="left">&nbsp;작성자</th>
					<th>댓글</th>
					<th>작성일자</th>
					<th align="right">삭제</th>
				</tr>
				<c:if test="${!empty list }">
					<c:forEach items="${list}" var="vo1">
					<tr align="center">
					<td align="left">&nbsp;${vo1.rpId }</td>
					<td>${vo1.rpContent}</td>
					<td>${vo1.rpDate }</td>
					<td align="right"><input type="button" value="삭제" onclick="location.href='/board/deleteReply?bdNum=${vo.bdNum}&rpNum=${vo1.rpNum}'"></td>
					</tr>
					
					</c:forEach>
				</c:if>
			</table>
			<form action="/board/insertReply" method="post">
			<input type="hidden" name="bdNum" value="${vo.bdNum }">
			<table border="0" align="center">
				<tr>
					<td width="10%"><input type="text" name="rpId" ></td>
					<td width="110%"colspan="2"><input type="text" name="rpContent"></td>
					<td align="right"><input type="submit" value="댓글달기"></td>
				</tr>
			</table>
			</form> --%>

		</div>
			
		
	</main>
</section>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>

<script>
</script>
</body>
</html>
