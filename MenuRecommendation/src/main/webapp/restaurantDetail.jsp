<%@page import="MT.model.RestmenuVO"%>
<%@page import="java.util.List"%>
<%@page import="MT.model.RestaurantVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		RestaurantVO vo = (RestaurantVO)request.getAttribute("restaurantVO");
	%>
	<div class = 'controlWrap'>
		<img src="images/backAllowIcon.png" width = "50px" height = "50px"/>
	</div>
	<div class = 'restaurantWrap'>
		<div class = 'restaurantDtail'>
			<p class = 'restaurantName'><%=vo.getRest_nm() %></p>
			<p class = 'restaurantCate'><%=vo.getSub_cate() %></p>
			<script> //지도가 들어갈자리! </script>
			<p class = 'restaurantAddr'<%=vo.getRest_addr() %>>주소 : 용봉동 용봉빌딩 5층</p>
			<p class = 'restaurantOpenTime'>영업시간 : (월-금)10:00 ~ 19:00</p>
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