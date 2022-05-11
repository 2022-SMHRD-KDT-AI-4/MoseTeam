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
				<%for(ComuVO cvo : list){ %>
				<%-- ���߿� view�� join�ؼ� �ۼ��� �г������� �����ϱ� --%>
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


		<a href="comuWrite"><button id="writer">���ۼ�</button></a>
		
		<form action="SearchService" method="get" class="boardSearch">
		<tr>
			<td colspan="3"><input name="search" type="text"></td>
			<td align="left"><button type="submit" onclick="boardSearch()">�˻�</button></td>
		</tr>
		</form>

	</div>
	

</body>
</html>