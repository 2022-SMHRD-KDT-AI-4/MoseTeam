<%@page import="MT.model.MemberVO"%>
<%@page import="MT.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/comu.css?ver=1">
<script src="js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
		List<BoardVO> list2 = (List<BoardVO>)request.getAttribute("list2");
	%>
	<div id="board">
		<table id="list" border="1" cellspacing="0">
<<<<<<< HEAD
		<caption class="cap">인기글</caption>

=======
		
		<caption>인기글</caption>
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-AI-4/MoseTeam.git
			<colgroup>
            <col width="5%">
            <col width="5%">
            <col width="50%">
            <col width="30%">
            <col width="10%">
			</colgroup>
			<thead>
				<tr>
					<td>번호</td>
					<td>추천수</td>
					<td>제목</td>
					<td>작성자</td>
					<td>시간</td>
				</tr>
			</thead>
			
			<%-- 공지사항 --%>
			<tbody>
				<%for(BoardVO vo : list2){ %>
				<tr>
					<td><b><%=vo.getBOARD_NO() %></b></td>
					<td><b><%=vo.getGOOD() %></b></td>
					<td><a href="ViewService?num=<%=vo.getBOARD_NO() %>">
						<b><%=vo.getBOARD_TITLE() %></b></a></td>
					<td><b><%=vo.getWRITER() %></b></td>
					<td><b><%=vo.getWRITE_DATE() %></b></td>
				</tr>
					
				<%} %>
			</tbody>
			
			
			<colgroup>
				<col>
				<col width="110">
				<col width="100">
				<col width="80">
			</colgroup>
			
			<%-- 인기순 게시글 --%>
			<tbody>
				<%for(BoardVO vo : list){ %>
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


		<a href="comuWrite.jsp"><button id="writer">글작성</button></a>
		
		<form action="SearchService" method="get" class="boardSearch">
		<tr>
			<td colspan="3"><input name="search" type="text"></td>
			<td align="left"><button type="submit" onclick="boardSearch()">검색</button></td>
		</tr>
		</form>

	</div>
</body>
</html>