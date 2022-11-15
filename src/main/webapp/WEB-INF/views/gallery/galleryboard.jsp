

<script type="text/javascript" src="../js/jquery/jquary-paging-ui.js">

</script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<html>
<head>
<style type="text/css">

.wrapper{
	display:flex;
	flex-direction:column;
	height:100%;
	align-items:center;
}

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
.flex{
	display:grid;
	grid-template-columns: repeat(3,1fr);
	flex-wrap:wrap;
	
	grid-gap:4rem;
	
	justify-content:space-around;
	
}

.each_item{
	width:350px;
	heigt:350px;
	text-decoration:none;
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
		<div class="wrapper" align="center">
		
		<div class="flex">
<!-- 		<div class="list" >
		</div> -->
		</div>
		
		<!-- <table border="0" align="center">
			<tr align="center">
				<th>게시글번호</th>
				<th>제목</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
			<tbody class="list">
			</tbody> 
		</table> -->
		
		
		</div>
		<br><br>
			<div class="pageNav" id="pageNav"></div>
			<div align="right"><input type="button" value="게시글작성" onclick="location.href='/gallery/writeGallery'">&nbsp;</div>
			
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
		url:'/gallery/getGalleryList',
		data:data,
		error :function(error){
			alert("error");
		},
		success:function (value){
			let html="";
			$(".flex").children().remove();
			if(value.length<1){
				html+= '<span>공지사항 목록이 없습니다</span>';
				} else{
					for(let i=0;i<value.list.length;i++){
						
						html+='<div class="each_item">';
						html+='<a href="/gallery/contentGalleryBoard?bdNum='+value.list[i].bdNum+'"><img src="/resources/img/'+value.list[i].savedFileName+'" width="300" height="300"></a>';
						html+='<br>'+value.list[i].bdTitle;
						html+='<br>'+value.list[i].bdRegdate+'</div>';
											
						/* html+='<tr><td align="center">'+ value.list[i].bdNum+'</td>';
						html+='<td><img src="/resources/img/'+value.list[i].savedFileName+'" width="100" height="100"></td>';
						html+='<td align="center"><a href="/gallery/contentGalleryBoard?bdNum='+value.list[i].bdNum+'">'+value.list[i].bdTitle+'</a></td>';
						html+='<td align="center">'+ value.list[i].bdRegdate+'</td>';
						html+='<td align="center">'+ value.list[i].bdCount+'</td>';
						html+='</tr>';			 */ 			
						
					}
				}
				$(".flex").append(html);
				
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
