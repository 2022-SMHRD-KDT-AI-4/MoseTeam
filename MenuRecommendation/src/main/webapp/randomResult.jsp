<%@page import="MT.model.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="css/RRS.css" />
<script src="js/jquery-3.6.0.min.js"></script>
<title>��õ �޴� ���</title>
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
			<P class = "menuDiscript"> ������ũ�� ���ִ� </P>
		</div>
		<div class="restaurantList">
			<div class="restaurantWrap">
				������ũ����
				<button class="resBtn">
					<a href='#'>������>></a>
				</button>
				<button class="btnChoice">Pick!</button>
				<p class="rmenuName">��ɽ�����ũ ---20000��</p>
			</div>
			<div class="restaurantWrap">
				�ٽ�����ũ
				<button class="resBtn">
					<a href='#'>������>></a>
				</button>
				<button class="btnChoice">Pick!</button>
				<p class="rmenuName">��ɽ�����ũ ---11000��</p>
				<p class="rmenuName">�Ƚɽ�����ũ ---15000��</p>
			</div>
			<div class="restaurantWrap">
				�Ͽ��̽�����ũ
				<button class="resBtn">
					<a href='#'>������>></a>
				</button>
				<button class="btnChoice">Pick!</button>
				<p class="rmenuName"></p>
			</div>
		</div>
	</div>
</body>
</html>