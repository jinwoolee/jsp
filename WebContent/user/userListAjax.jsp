<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<style>
	#userList tr {cursor: pointer;}
</style>

<%@ include file="/commonJsp/jquery.jsp" %>
<%@ include file="/commonJsp/bootstrap.jsp" %>

<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script>
$(document).ready(function(){

	//사용자 클릭시 상세 조회 화면 이동
	$("#userList").on("click", "tr", function(){
		
		/*"data-productId"  translates to "productid"
		"data-product-id" translates to "productId"
		"data-PRODUCT-ID" translates to "productId"
		"data-ProDUctId"  translates to "productid"*/
		var userId = $(this).data("userid");
		
		$(location).attr("href", "<%=request.getContextPath()%>/user/getUser?userId=" + userId);
	});
	
	/*
	<tr class="clickable-row" data-userid="${userVo.userId}">	
	<td>${userVo.userId}</td>
	<td>${userVo.userNm}</td>
	<td>${userVo.userAlias}</td>
	<td><fmt:formatDate value="${userVo.reg_dt}" pattern="YYYY-MM-dd"/> </td>
</tr>
*/
	getPage(1);
	
	
});

/*$(window).on('hashchange', function() {
	console.log("hashchange");
	 var page = parseInt(location.hash.slice(5));
	 console.log("hashchange " + page) ;
	  //if (!!page && currentPage !== page) {
	    getPage(page);
	  //}
});*/

$(window).on('popstate', function(event) {
  var data = event.originalEvent.state;
    jQuery('#userList').html(data.userList);
  	jQuery(".pagination").html(data.pageNav);
});

function getPage(page){
	$.ajax({
	  dataType: "json",
	  url: "/user/userListPage",
	  data: "page=" + page,
	  success: function(data){
		jQuery("#userList").empty();
		
	  	jQuery.each(data.userList, function(idx, obj){
	  		var html = "";
	  		html	 += "<tr class=\"clickable-row\" data-userid=\"" + obj.userId + "\">";	
	  		html	+=	"<td>" + obj.userId + "</td>";
	  		html	+=	"<td>" + obj.userNm + "</td>";
	  		html	+=	"<td>" + obj.userAlias + "</td>";
	  		html	+=	"<td>" + obj.reg_dt + "</td>";
	  		jQuery("#userList").append(html);
	  	});
	  	
	  	jQuery(".pagination").html(data.pageNav);
	  	
	  	//window.location.hash = "#page" + page;
	  	history.pushState({userList: jQuery("#userList").html(), pageNav: data.pageNav}, 'Page '+ page, '/user/userListAjax');
	  }
	});

	/*$.getJSON('/user/userListPage' + page, function(data) {
    		console.log(data);
    }).join('');
    $('#list').html(list);
    $('#next').attr('href', '/pushstate/page' + (+page+1));
    history.pushState({list: list, page: page}, 'Page '+ page, '/pushstate/page' + page);
  });	*/
}

</script>


  
</head>

<body>
	<jsp:include page="/commonJsp/header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="/commonJsp/leftMenu.jsp" />
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<jsp:include page="/user/userListAjaxContent.jsp" />
			</div>
		</div>			
	</div>	
</body>
</html>
