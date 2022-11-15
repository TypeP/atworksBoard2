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
			<h1>갤러리게시판 페이지</h1>
			<form action="/gallery/writeGalleryBoard" method="post" enctype="multipart/form-data" novalidate>
			<table border="0" align="center" width='500' >
				<tr>
					<th>갤러리 게시글 제목</th>
					<td><input type="text" name="bdTitle">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="bdWriter">
					</td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><textarea rows="3" cols="50" name="bdContent"></textarea>
					</td>
				</tr>
				<tr>
					<th><label for="File">파일</label></th>
					<td><input type="file" multiple="multiple" id="file" name="file" class="form-control"></td>					
				
				</tr>
						
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="게시글 작성">&nbsp;&nbsp;
						<input type="reset" value="게시글 다시작성">
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
