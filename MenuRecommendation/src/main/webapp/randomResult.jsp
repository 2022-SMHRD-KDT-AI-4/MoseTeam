<%@page import="java.util.List"%>
<%@page import="MT.model.RestmenuVO"%>
<%@page import="MT.model.RestaurantVO"%>
<%@page import="MT.model.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" type="text/css" href="css/RRS.css?ver=1" />
<script src="js/jquery-3.6.0.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Gugi&family=Stylish&display=swap');
</style>
<title>추천 메뉴 결과</title>
</head>
<body>
	<%
	MenuVO vo = (MenuVO) request.getAttribute("menuvo");
	List<RestaurantVO> restList = (List) request.getAttribute("restList");
	%>
	<div>
		<button class="relode" onclick="homereload()">이거 말고</button>
		<div class="menuWrap">
			<p class="menuName"><%=vo.getMenu_nm()%></p>
			<img
				src=<%=vo.getImage_path() == null ? "https://img.apti.co.kr/aptHome/images/sub/album_noimg.gif" : vo.getImage_path()%>
				width="100%">
			<P class="menuDiscript">
				<%=vo.getDiscript()%>
			</P>
		</div>
		<div class="restaurantList">
			<%
			if (restList != null) {
				for (int r = 0; r < restList.size(); r++) {
			%>
				<div class="restaurantWrap">
					<%=restList.get(r).getRest_nm()%>
					<button class="resBtn" onclick="location.href='RestaurantService?rest_id=<%=restList.get(r).getRest_id()%>'">상세정보</button>
					<button class="btnChoice" value = <%=restList.get(r).getRest_id()%>>Pick!</button>
					<P><%
					List<RestmenuVO> rmenuList = restList.get(r).getRestMenu();
					for (int rm = 0; rm < rmenuList.size(); rm++) {
					%></P>
					
						<span class="rmenuName"><%=rmenuList.get(rm).getRmenu_nm()%></span>
						<span class="rmenuPrice"><%= "    -----" + rmenuList.get(rm).getPrice()%></span>
						<br>
					<%}%>
				</div>
			<%}
			}%>
		</div>
	</div>
	<script>
			function homereload(){
				window.location.reload();
			}
</script>
	<script>
		$('.btnChoice').on('click', function(){
			let rest_id = $(this).val();
			
			$.ajax({
				url : 'RestChoiceService',
				type : 'POST',
				data : {
					"rest_id" : rest_id
				},
				// dataType : '',
				success : function(res){
					console.log(res);
					alert('확인! 마이페이지로 이동하시겠습니까??');
				},
				error : function(){
					elert('저장 실패');
				}
			})
		});
	</script>
</body>
</html>