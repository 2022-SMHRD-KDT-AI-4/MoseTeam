<%@page import="MT.model.MemberVO"%>
<%@page import="MT.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name = "viewport" content="width=device-width , initial-scale=1">
<link rel = "stylesheet" type = "text/css" media = "screen" href="./comment.css">
<link rel = "stylesheet" href="https://stackpath.bootstranpcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		BoardVO vo = (BoardVO)request.getAttribute("bvo");
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
						<td><%=vo.getBOARD_NO() %></td>
						<th class="success">추천수</th>
						<td><%=vo.getGOOD() %></td>
						<td>
						<a href="GoodAddService?num=<%=vo.getBOARD_NO() %>"><button>추천하기</button></a>
						</td>
					</tr>


					<tr>
						<th class="success">작성자</th>
						<td><%=vo.getWRITER() %></td>
						<th class="success">작성일</th>
						<td><%=vo.getWRITE_DATE() %></td>
					</tr>

					<tr>
						<th class="success">제목</th>
						<td colspan="3"><%=vo.getBOARD_TITLE() %></td>
					</tr>
					<tr>
						<th class="success">글 내용(이미지)</th>
						<td colspan="3">
						<img alt="" src="comuFileImg/<%=vo.getFILE_NAME() %>"></td>
					</tr>
					
					<tr>
						<th class="success">글 내용(텍스트)</th>
						<td colspan="3"><%=vo.getBOARD_CONTENT() %></td>
					</tr>

					<tr>
						<td colspan="4" class="text-center">
							<%-- 댓글작성 미완성 --%>
							<input type="button" class="btn btn-wirte" value="댓글 쓰기"
							onclick="location.href='BoardReWriteForm.jsp?num=  &ref=  &ref_step=  &ref_level='">
							
							<a href="BEditLoadService?num=<%=vo.getBOARD_NO() %>"><button>수정하기</button></a>
							
							<a href="BDeleteService?num=<%=vo.getBOARD_NO() %>"><button>삭제하기</button></a>
							
							<a href="ListService"><button>목록보기</button></a>
							
						</td>
					</tr>
					<tr>신고버튼 및 추가 빈공간</tr>
					<tr>댓글출력공간</tr>
	<div id = "form-commentInfo">
		<div id = "comment-count"> 댓글 <span id ="count">0</span></div>
		<input id = "comment-input" placeholder="댓글을 입력해 주세요.">
		<button id = "submit">등록</button>
	</div>
	<div id = comments>
	</div>
	<script src="./comment.js"></script>
</body>
</html>