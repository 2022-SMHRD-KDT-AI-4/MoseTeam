<%@page import="MT.model.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="css/RRS.css" />
<script src="js/jquery-3.6.0.min.js"></script>
<title>추천 메뉴 결과</title>
</head>
<body>
	<%
	MenuVO vo = (MenuVO) request.getAttribute("menuvo");
	%>
	<div>
		<div class="menuWrap">
			<p class="menuName"><%=vo.getMenu_nm()%></p>
			<img
				src=<%=vo.getImage_path() == null ? "https://img.apti.co.kr/aptHome/images/sub/album_noimg.gif" : vo.getImage_path()%>
				width="100%"> 
			<P class = "menuDiscript"> 스테이크는 맛있다 </P>
		</div>
		<div class="restaurantList">
			<div class="restaurantWrap">
				스테이크보스
				<button class="resBtn">
					<a href='#'>상세정보>></a>
				</button>
				<button class="btnChoice">Pick!</button>
				<p class="rmenuName">등심스테이크 ---20000원</p>
			</div>
			<div class="restaurantWrap">
				핵스테이크
				<button class="resBtn">
					<a href='#'>상세정보>></a>
				</button>
				<button class="btnChoice">Pick!</button>
				<p class="rmenuName">등심스테이크 ---11000원</p>
				<p class="rmenuName">안심스테이크 ---15000원</p>
			</div>
			<div class="restaurantWrap">
				하와이스테이크
				<button class="resBtn">
					<a href='#'>상세정보>></a>
				</button>
				<button class="btnChoice">Pick!</button>
				<p class="rmenuName"></p>
			</div>
		</div>
	</div>
</body>
</html>