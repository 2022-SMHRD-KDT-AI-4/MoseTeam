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
<title>�˻�</title>
</head>
<body>

	<%
		List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
	%>
	<div id="board">
		<table id="list" border="1" cellspacing="0">
			<caption class="cap">�Խñ�</caption>
			<colgroup>
            <col width="5%">
            <col width="8%">
            <col width="42%">
            <col width="30%">
            <col width="15%">
			</colgroup>
			<thead class="head">
				<tr>
					<td>��ȣ</td>
					<td>��õ��</td>
					<td>����</td>
					<td>�ۼ���</td>
					<td>�ð�</td>
				</tr>
			</thead>
			<tbody>
				<%for(BoardVO vo : list){ %>
				<%-- ���߿� view�� join�ؼ� �ۼ��� �г������� �����ϱ� --%>
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
			<td id="writer"><button class="writer"><a href="comuWrite.jsp">���ۼ�</a></button></td>
			<td align="right" id="btn"><button class="btn" type="submit" onclick="boardSearch()">�˻�</button></td>
			<td colspan="3" id="input"><input class="input" name="search" type="text"></td>
		</tr>
		</form>

	</div>
	

</body>
</html>