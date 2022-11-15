

<script type="text/javascript" src="../js/jquery/jquary-paging-ui.js">

</script>
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

#search{
 width:10%;
}

#searchbutton{
 width:4%;
}

#pageNav{
padding-left:250px;
font-color:blue;
}

.active{
font-size:15px;
font-color:blue;



}
</style>
	<title>atworks</title>
</head>
<%@ include file="/WEB-INF/views/include/script.jsp" %>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>


 
<section class="main_wrap">
	<main class="main">
		
		<h2 align="center">atworks 게시판</h2>
		<div class="util_menu" style='white-space:nowrap;'>
		<select id="searchType" class="field">
			<option value="bd_title">제목</option>
			<option value="bd_content">내용</option>
			<option value="bd_writer">작성자</option>
			<option value="all">전체</option>
		</select>
			<input type="text"id="search">
			<input type="button" id="searchbutton" value="검색">
		</div>
		<div align="center">
		<table border="0" align="center">
			<tr align="center">
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
			<tbody class="list">
			</tbody>
		</table>
		</div>
			<div class="pageNav" id="pageNav"></div>
			<div align="right"><input type="button" value="공지사항작성" onclick="location.href='/ajax/writeAjaxBoard'">&nbsp;</div>
			
	</main>
</section>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>

<script>
$(document).ready(function(){
	getList(1);
	$('#searchbutton').click(function(){
		getList(1);
	});
});

function getList(selectPage){
	let data={};
	data.pagePerCnt=10;
	data.curPage=selectPage;
	data.keyword=$("#search").val();
	data.searchType=$("#searchType option:selected").val();
	
	$.ajax({
		type:'GET',
		url:'/ajax/getList',
		data:data,
		error :function(error){
			alert("error");
		},
		success:function (value){
			let html="";
			$(".list").children().remove();
			if(value.length<1){
				html+= '<span>공지사항 목록이 없습니다</span>';
				} else{
					for(let i=0;i<value.list.length;i++){
						html+='<tr><td align="center">'+ value.list[i].bdNum+'</td>';
						html+='<td align="center"><a href="/ajax/contentAjaxBoard?bdNum='+value.list[i].bdNum+'">'+value.list[i].bdTitle+'</a></td>';
						html+='<td align="center">'+ value.list[i].bdRegdate+'</td>';
						html+='<td align="center">'+ value.list[i].bdCount+'</td>';
						html+='</tr>';						
					}
				}
				$(".list").append(html);
				
				let pagingHtml=paging({
					pagePerCnt:value.pagePerCnt,
					currentPage:value.curPage,
					totalCnt:value.totalCnt
				});
				
				$(".pageNav").empty().append(pagingHtml);
		
			}
		});
	}
	
	function goPage(selectPage){
		getList(selectPage);
	}


</script>
</body>
</html>
