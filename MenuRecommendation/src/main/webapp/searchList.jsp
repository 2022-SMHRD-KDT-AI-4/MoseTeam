<%@page import="MT.model.ComuVO"%>
<%@page import="java.util.List"%>
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
		List<ComuVO> list = (List<ComuVO>)request.getAttribute("list");
	%>
	<div id="board">
		<table id="list" border="1" cellspacing="0">
			<caption>게시글</caption>
			<colgroup>
				<col>
				<col width="110">
				<col width="100">
				<col width="80">
			</colgroup>
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>시간</td>
				</tr>
			</thead>
			<tbody>
				<%for(ComuVO cvo : list){ %>
				<%-- 나중에 view로 join해서 작성자 닉네임으로 변경하기 --%>
				<tr>
					<td><%=cvo.getBOARD_NO() %></td>
					<td><a href="ViewService?num=<%=cvo.getBOARD_NO() %>">
						<%=cvo.getBOARD_TITLE() %></a></td>
					<td><%=cvo.getMEMBER_ID() %></td>
					<td><%=cvo.getWRITE_DATE() %></td>
				</tr>
					
				<%} %>
			</tbody>

		</table>


		<a href="comuWrite"><button id="writer">글작성</button></a>
		
		<form action="SearchService" method="get" class="boardSearch">
		<tr>
			<td colspan="3"><input name="search" type="text"></td>
			<td align="left"><button type="submit" onclick="boardSearch()">검색</button></td>
		</tr>
		</form>

	</div>
	

</body>
</html>