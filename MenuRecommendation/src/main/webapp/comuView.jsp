<%@page import="MT.model.ComuVO"%>
<%@page import="MT.model.MemberVO"%>
<%@page import="MT.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		ComuVO cvo = (ComuVO)request.getAttribute("cvo");
	%>
	
	
	<div class="row">
		<div class="col-xs-2 col-md-2"></div>
		<div class="col-xs-8 col-md-8">
			<h2 class="text-center">게시글 보기</h2>
			<p>&nbsp;</p>
			<div class="table table-responsive">
				<table class="table">
					<tr>
						<th class="success">글번호</th>
						<td><%=cvo.getBOARD_NO() %></td>
						<th class="success">조회수</th>
						<td><%-- 조회수 미작성 --%></td>
					</tr>


					<tr>
						<th class="success">작성자</th>
						<td><%=cvo.getNICK_NM() %></td>
						<th class="success">작성일</th>
						<td><%=cvo.getWRITE_DATE() %></td>
					</tr>

					<tr>
						<th class="success">제목</th>
						<td colspan="3"><%=cvo.getBOARD_TITLE() %></td>
					</tr>
					<tr>
						<th class="success">글 내용(이미지)</th>
						<td colspan="3"><%=cvo.getFILE_NAME() %></td>
					</tr>
					
					<tr>
						<th class="success">글 내용(텍스트)</th>
						<td colspan="3"><%=cvo.getBOARD_CONTENT() %></td>
					</tr>

					<tr>
						<td colspan="4" class="text-center">
							<%-- 댓글작성 미완성 --%>
							<input type="button" class="btn btn-wirte" value="답글 쓰기"
							onclick="location.href='BoardReWriteForm.jsp?num=  &ref=  &ref_step=  &ref_level='">
							
							<a href="BEditService"><button>수정하기</button></a>
							
							<a href="BDeleteService"><button>삭제하기</button></a>
							
							<a href="ListService"><button>목록보기</button></a>
							
						</td>
					</tr>
					<tr>신고버튼 및 추가 빈공간</tr>
					<tr>댓글출력공간</tr>
</body>
</html>