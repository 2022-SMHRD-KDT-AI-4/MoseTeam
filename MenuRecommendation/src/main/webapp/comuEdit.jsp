<%@page import="MT.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/comuW.css?ver=2">
</head>
<body>

	<%
		BoardVO vo = (BoardVO)request.getAttribute("bvo");
	%>

			<div id = "board">
				<form action="BEditService" method="post" >
				<table id="list">
					<tr>
					
						<td>제목</td>
						<td><input name="title" type="text"  value="<%=vo.getBOARD_TITLE() %>">
							<input name="num" type="hidden" value="<%=vo.getBOARD_NO() %>">
						</td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="content" rows="10" style="resize: none;"><%=vo.getBOARD_CONTENT() %></textarea>			
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="reset" value="초기화">
							<input type="submit" value="작성하기">
						</td>
					</tr>
				</table>
				</form>
			</div>
</body>
</html>