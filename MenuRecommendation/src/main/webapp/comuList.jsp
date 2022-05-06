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
				<tr>
					<td>001</td>
					<td>임시</td>
					<td>smhrd</td>
					<td>220506</td>
				</tr>
				<tr>
					<td>002</td>
					<td>임시2</td>
					<td>smhrd</td>
					<td>220506</td>
				</tr>
				<tr>
					<td>003</td>
					<td>임시3</td>
					<td>smhrd</td>
					<td>220506</td>
				</tr>
			</tbody>

		</table>


		<a href="#"><button id="writer">글작성</button></a>

		<tr>
			<td colspan="3"><input name="search" type="text"></td>
			<td align="left"><button onclick="boardSearch()">검색</button></td>
		</tr>

	</div>
</body>
</html>