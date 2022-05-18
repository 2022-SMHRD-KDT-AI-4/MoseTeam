<%@page import="MT.model.RestmenuVO"%>
<%@page import="java.util.List"%>
<%@page import="MT.model.RestaurantVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>식당 상세</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Stylish&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Stylish&display=swap');
	@import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Gugi&family=Stylish&display=swap');
</style>	
<link rel="stylesheet" type="text/css" href="css/RD.css" />
</head>
<body>
	<%
		RestaurantVO vo = (RestaurantVO)request.getAttribute("restaurantVO");
	%>
	<div class = 'controlWrap'>
		<img src="images/backAllowIcon.png" width = "50px" height = "50px" onclick="history.back()">
	</div>
	<div class = 'restaurantWrap'>
		<div class = 'restaurantDtail'>
			<p class = 'restaurantName'><%=vo.getRest_nm() %></p>
			<p class = 'restaurantCate'><%=vo.getSub_cate() %></p>
			<script> //지도가 들어갈자리! </script>
			<p class = 'restaurantAddr'><%=vo.getRest_addr() %></p>
			<p class = 'restaurantOpenTime'>-</p>
		</div>
		<div class = 'rMenuList'>
			<% 
				List<RestmenuVO> list = vo.getRestMenu();
				for(int i = 0; i<list.size(); i++){ %>
				<div class = 'rMenuWrap'>
					<p class = 'menuName'><%=list.get(i).getRmenu_nm() %></p>
					<p class = 'menuPrice' text-align = 'right'>-----<%=list.get(i).getPrice() %></p>
				</div>
			<%} %>
		</div>
	</div>
</body>
</html>