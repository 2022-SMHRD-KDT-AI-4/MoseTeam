<%@page import="MT.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/comu.css?ver=3">
<script src="js/jquery-3.6.0.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Gugi&family=Stylish&display=swap');
</style>
<title>검색</title>
</head>
<body>

	<%
		List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
	%>
	<div id="board">
		<table id="list" border="1" cellspacing="0">
			<caption class="cap">게시글</caption>
			<colgroup>
            <col width="5%">
            <col width="8%">
            <col width="42%">
            <col width="30%">
            <col width="15%">
			</colgroup>
			<thead class="head">
				<tr>
					<td>번호</td>
					<td>추천수</td>
					<td>제목</td>
					<td>작성자</td>
					<td>시간</td>
				</tr>
			</thead>
			<tbody>
				<%for(BoardVO vo : list){ %>
				<%-- 나중에 view로 join해서 작성자 닉네임으로 변경하기 --%>
				<tr>
					<td><%=vo.getBOARD_NO() %></td>
					<td><%=vo.getGOOD() %></td>
					<td><a href="ViewService?num=<%=vo.getBOARD_NO() %>">
						<%=vo.getBOARD_TITLE() %></a></td>
					<td><%=vo.getWRITER() %></td>
					<td><%=vo.getWRITE_DATE() %></td>
				</tr>
					
				<%} %>
			</tbody>

		</table>


		<form action="SearchService" method="get" class="boardSearch">
		<tr>
			<td id="writer"><button class="writer"><a href="comuWrite.jsp">글작성</a></button></td>
			<td align="right" id="btn"><button class="btn" type="submit" onclick="boardSearch()">검색</button></td>
			<td colspan="3" id="input"><input class="input" name="search" type="text"></td>
		</tr>
		</form>

	</div>
	

</body>
</html>