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
			<c:set var="vo" value="${cont}"/>
			<table border="0" align="center" width='500' >
				<tr>
					<th>게시글 제목</th>
					<td><input type="text" name="bdTitle" value="${vo.bdTitle}" readonly>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>
					<c:if test="${!empty vo.bdModwriter }">
						<input type="text" name="bdModwriter"value="${vo.bdModwriter}" readonly>
					</c:if>
					<c:if test="${empty vo.bdModwriter }">
						<input type="text" name="bdWriter"value="${vo.bdWriter}" readonly>
					</c:if>
					</td>
				</tr>
				<tr>
					<th>게시글 내용</th>
					<td><textarea rows="3" cols="50" name="bdContent"  readonly>${vo.bdContent}</textarea>
					</td>
				</tr>
				<c:if test="${!empty vo.bdModdate}">
					<tr>
						<th>수정일자</th>
						<td><input type="text" name="bdModdate"value="${vo.bdModdate}" readonly>
						</td>
					</tr>
				</c:if>
					
				<c:if test="${empty vo.bdModdate}">
					<tr>
						<th>작성일자</th>
						<td><input type="text" name="bdRegdate"value="${vo.bdRegdate}" readonly></td>
					</tr>
				</c:if>
					
				
				<tr>
					<td colspan="2" align="center">
					<input type="button" value="게시글수정" onclick="location.href='/ajax/modifyAjaxBoard?bdNum=${vo.bdNum}'">
						<input type="reset" value="게시글 삭제" onclick="location.href='/ajax/deleteAjaxBoard?bdNum=${vo.bdNum}'">
						<input type="button" value="전체목록" onclick="location.href='/ajax/indexAjaxBoard'">
					</td>
				</tr>
								
			</table>
			
				<table border="0" align="center">
				<tr align="center">
					<th align="left">&nbsp;작성자</th>
					<th>댓글</th>
					<th>작성일자</th>
					<th align="right">삭제</th>
				</tr>
				
				<tbody class="list">
				</tbody>
			</table>
			<form action="/ajax/insertReplyAjax" method="post">
			<input type="hidden" name="bdNum" value="${vo.bdNum }">
			<table border="0" align="center">
				<tr>
					<td width="10%"><input type="text" id="rpId" name="rpId" ></td>
					<td width="110%"colspan="2"><input type="text" id="rpContent" name="rpContent"></td>
					<td align="right"><input type="submit" id="replybtn" value="댓글달기"></td>
				</tr>
			</table>
			</form>
		</div>	
	</main>
</section>
<script>
$(document).ready(function(){
	getRepList();
	$('#replybtn').click(function(){
		getRepList();
	});
	
	$('#deletebtn').click(function(){
		getRepList();
	});
});

function getRepList(){
	let data={};
	data.bdNum=${vo.bdNum};

	$.ajax({
		type:'GET',
		url:'/ajax/getRepList',
		data:data,
		error:function(error){
			alert("error");
		},
		success:function (value){
			let html="";
			$(".list").children().remove();
			if(value.length<1){
				html+='<span>공지사항 목록이 없습니다</span>';
			} else{
				for(let i=0;i<value.list.length;i++){
					html+='<tr align="center"><td align="left" >'+value.list[i].rpId+'</td>';
					html+='<td>'+value.list[i].rpContent+'</td>';
					html+='<td>'+value.list[i].rpDate+'</td>';
					html+='<td align="right"><input id="deletebtn" type="button" value ="삭제" onClick="location.href=`/ajax/deleteReply?bdNum='+${vo.bdNum}+'&rpNum='+value.list[i].rpNum+'`"></td>';
					html+='</tr>';
					
				}
			}
			$(".list").append(html);
		}
	})
}



</script>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
