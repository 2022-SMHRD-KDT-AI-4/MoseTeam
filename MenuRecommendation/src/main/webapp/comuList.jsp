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
			<caption>�Խñ�</caption>
			<colgroup>
				<col>
				<col width="110">
				<col width="100">
				<col width="80">
			</colgroup>
			<thead>
				<tr>
					<td>��ȣ</td>
					<td>����</td>
					<td>�ۼ���</td>
					<td>�ð�</td>
				</tr>
			</thead>
			<tbody>
				<%for(BoardVO bvo : list){ %>
				<%-- ���߿� view�� join�ؼ� �ۼ��� �г������� �����ϱ� --%>
				<tr>
					<td><%=bvo.getBOARD_NO() %></td>
					<td><a href="ViewService?num=<%=bvo.getBOARD_NO() %>"><%=bvo.getBOARE_TITLE() %></a></td>
					<td><%=bvo.getMEMBER_ID() %></td>
					<td><%=bvo.getWRITE_DATE() %></td>
				</tr>
					
				<%} %>
			</tbody>

		</table>


		<a href="#"><button id="writer">���ۼ�</button></a>

		<tr>
			<td colspan="3"><input name="search" type="text"></td>
			<td align="left"><button onclick="boardSearch()">�˻�</button></td>
		</tr>

	</div>
</body>
</html>