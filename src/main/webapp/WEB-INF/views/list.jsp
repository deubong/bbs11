<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.3/c3.min.css"
	rel="stylesheet" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/5.9.7/d3.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.3/c3.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>

<html>
<head>
<meta charset="utf-8">
<title>게시판</title>
<style type="text/css">
#container {
	margin: 0 auto;
}

h2 {
	text-align: center;
}
</style>
</head>

<body>
	<!-- !!!!!!!!!!다른 jsp 화면 안에 집어 넣기!!!!!!!!! 
	<c:if test="${id!=null}">
		<%@include file="loginOk.jsp"%>
	</c:if>
 
	<c:if test="${id==null}">
		<%@include file="login.jsp"%>
	</c:if>
	-->

	<td align="center" width="100">${articleList[0].gu}</td>
	<td align="center" width="150">${articleList[0].dong}</td>
	<td align="center" width="50">${articleList[0].result1}</td>

	<%@include file="search.jsp"%>
 
	<!--   bindto : '#chart',  -->

	<div style="width: 500px">
		<div id="chart" />
	</div>
	<script>
		$(function() {
			var chart = c3.generate({
				bindto : '#chart',
				data : {
					columns : [ 
								['${articleList[0].dong}','${articleList[0].result1}'] 
						],
					type : 'bar'
				},
				bar : {
					width : {
						ratio : 0.5
					}
				}
			});
		});
	</script>



</body>
</html>