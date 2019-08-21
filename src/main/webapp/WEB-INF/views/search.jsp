<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BBSServlet" method="post" enctype="UTF-8">
			<select id="gu" name = "gu">
				<option value="금정구">금정구</option>
				<option value="동래구">동래구</option>
				<option value="해운대구">해운대구</option>
				<option value="연제구">연제구</option>
			</select> 
			<select id="dong" name="dong">
				<option value="전체">전체</option>
				<option value="장전1동">장전1동</option>
				<option value="장전2동">장전2동</option>
				<option value="장전3동">장전3동</option>
			</select> 
			<input type="submit" value="확인">
	</form>
</body>
</html>