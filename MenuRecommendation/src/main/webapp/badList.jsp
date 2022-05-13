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
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<script src="js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
	%>
	<div id="board">
		<table id="list" border="1" cellspacing="0">
		
		<caption>신고내역</caption>
			<colgroup>
				<col>
				<col width="110">
				<col width="100">
				<col width="80">
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
				<%for(BoardVO vo : list){ %>
				<tr>
					<td><%=vo.getBOARD_NO() %></td>
					<td><%=vo.getGOOD() %></td>
					<td><a href="ViewService?num=<%=vo.getBOARD_NO() %>">
						<%=vo.getBOARD_TITLE() %></a></td>
					<td><%=vo.getWRITER() %></td>
					<td><%=vo.getWRITE_DATE() %></td>
					
					<td><a href="BDeleteService?num=<%=vo.getBOARD_NO() %>">
						삭제</a></td>
				</tr>
					
				<%} %>
			</tbody>

		</table>

		</form>

	</div>
</body>
</html>