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
	<div class="row">
		<div class="col-xs-2 col-md-2"></div>
		<div class="col-xs-8 col-md-8">
			<h2 class="text-center">게시글 보기</h2>
			<p>&nbsp;</p>
			<div class="table table-responsive">
				<table class="table">
					<tr>
						<th class="success">글번호</th>
						<td></td>
						<th class="success">조회수</th>
						<td></td>
					</tr>


					<tr>
						<th class="success">작성자</th>
						<td></td>
						<th class="success">작성일</th>
						<td></td>
					</tr>

					<tr>
						<th class="success">제목</th>
						<td colspan="3"></td>
					</tr>

					<tr>
						<th class="success">글 내용</th>
						<td colspan="3"></td>
					</tr>

					<tr>
						<td colspan="4" class="text-center"><input type="button"
							class="btn btn-success" value="답글 쓰기"
							onclick="location.href='BoardReWriteForm.jsp?num=  &ref=  &ref_step=  &ref_level='">
							<input type="button" class="btn btn-warning" value="수정하기"
							onclick="location.href='BoardUpdateForm.jsp?num=  '">
							<input type="button" class="btn btn-danger" value="삭제하기"
							onclick="location.href='BoardDeleteForm.jsp?num=  '">
							<input type="button" class="btn btn-primary" value="목록보기"
							onclick="location.href='BoardList.jsp'"></td>
					</tr>
</body>
</html>