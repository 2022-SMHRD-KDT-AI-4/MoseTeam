<%@page import="MT.model.MemberVO"%>
<%@page import="MT.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="css/comu.css?ver=5">
<script src="js/jquery-3.6.0.min.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Gugi&family=Stylish&display=swap');
</style>
<title>�Խ���</title>
</head>
<body>
	<%
		List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
		List<BoardVO> list2 = (List<BoardVO>)request.getAttribute("list2");
	%>
	<div id="board">
			<h1 class="cap">�Խ���</h1>
				<form action="SearchService" method="get" class="boardSearch">
		<tr>
			<td id="writer"><button class="writer"><a href="comuWrite.jsp">���ۼ�</a></button></td>
			<td align="right" id="btn"><button class="btn" type="submit" onclick="boardSearch()">�˻�</button></td>
			<td colspan="3" id="input"><input class="input" name="search" type="text"></td>
		</tr>
		</form>
		<table id="list" border= "1" style=" border-radius: 10px; ">




			<colgroup>
		
            <col width="5%">
            <col width="8%">
            <col width="42%">
            <col width="30%">
            <col width="15%">
			</colgroup>
			<thead class="head" style=" border-radius: 10px; ">
				<tr>
					<td>��ȣ</td>
					<td>��õ��</td>
					<td>����</td>
					<td>�ۼ���</td>
					<td>�ð�</td>
				</tr>
			</thead>
			
			<%-- �������� --%>
			<tbody class="admin" style=" border-radius: 10px; ">
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
			

			
			<%-- �Խñ� --%>
			<tbody style=" border-radius: 10px;">
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


		


	</div>
</body>
</html>