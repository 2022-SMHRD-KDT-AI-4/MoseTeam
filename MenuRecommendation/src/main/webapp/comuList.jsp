<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
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
				<tr>
					<td>001</td>
					<td>�ӽ�</td>
					<td>smhrd</td>
					<td>220506</td>
				</tr>
				<tr>
					<td>002</td>
					<td>�ӽ�2</td>
					<td>smhrd</td>
					<td>220506</td>
				</tr>
				<tr>
					<td>003</td>
					<td>�ӽ�3</td>
					<td>smhrd</td>
					<td>220506</td>
				</tr>
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