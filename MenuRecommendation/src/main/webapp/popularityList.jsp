<%@page import="MT.model.MemberVO"%>
<%@page import="MT.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/comu.css">
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
			<tbody>
				<%for(BoardVO vo : list2){ %>
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