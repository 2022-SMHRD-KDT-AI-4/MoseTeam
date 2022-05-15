<%@page import="MT.model.ReplyVO"%>
<%@page import="MT.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="MT.model.ReviewVO"%>
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
		List<ReviewVO> list = (List<ReviewVO>)request.getAttribute("list");
		//List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
		//List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("list");
	%>

</body>
</html>