<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<style type="text/css">

.field{
	width:8%;
	margin-left:150px;
}
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
		
		<h2 align="center">atworks 게시판</h2>
		<c:set var="list" value="${list}"/>
		<div class="util_menu" style= 'white-space:nowrap;'>
		<form action="/board/search"method="post">
		<select name="field" class="field" >
			<option value="all">전체</option>
			<option value="bd_title">제목</option>
			<option value="bd_content">내용</option>
			<option value="bd_writer">작성자</option>
		</select>
			<input name="keyword">
			<input type="submit" value="검색">
		</form>
		</div>
		<div align="center">
		<table border="0" align="center">
			<tr align="center">
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
			<c:if test="${empty list}">
				<tr>
					<td>작성된 게시물이 없습니다</td>
				</tr>
			</c:if>
			
			<c:if test="${!empty list}">
				<c:forEach items="${list }" var="vo">
				<tr align="center">
					<td>${vo.bdNum }</td>
					<td><a href="/board/content?bdNum=${vo.bdNum}">${vo.bdTitle }</a></td>
					<td>
						<c:if test="${empty vo.bdModdate }">
							${vo.bdRegdate}
						</c:if>	
						<c:if test="${!empty vo.bdModdate }">
							${vo.bdModdate}
						</c:if>	
					</td>
					<td>${vo.bdCount }</td>
				</tr>	
					
				</c:forEach>
			</c:if>
				<tr>
					<td colspan="4" align="right">
						<input type="button" value="게시글작성" onclick="location.href='/board/writeBoard'">&nbsp;
					</td>
				</tr>
			
		</table>
		</div>
	</main>
</section>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
