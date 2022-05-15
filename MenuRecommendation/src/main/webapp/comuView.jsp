<%@page import="java.util.List"%>
<%@page import="MT.model.ReplyVO"%>
<%@page import="MT.model.MemberVO"%>
<%@page import="MT.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name = "viewport" content="width=device-width , initial-scale=1">
<link rel="stylesheet" href="css/comu.css">
<link rel = "stylesheet" href="https://stackpath.bootstranpcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		BoardVO vo = (BoardVO)request.getAttribute("bvo");
		List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("list");
		int count = (int)request.getAttribute("count");
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
						<td><a href="BadReportService?num=<%=vo.getBOARD_NO() %>"><button>신고하기</button></a>
					</tr>
					
					
					
	<div id="comment">
		<table>
		<thead>
			<form action="CommentService" method="get" class="addComment">
				<tr>
					<div> 댓글 <span id ="count"><%=count %></span></>
				</tr>
				<tr>
					<td colspan="3"><input name="comment" type="text" placeholder="댓글을 입력해 주세요."></td>
					<td colspan="3"><input name="bodnum" type="hidden" value="<%=vo.getBOARD_NO()%>"></td>
					<td colspan="3"><input name="id" type="hidden" value="yj1<%-- 세션 ID --%>"></td>
					<td colspan="3"><input name="nick" type="hidden" value="test<%-- 세션 ID 닉네임 --%>"></td>
					<td align="left"><button type="submit" onclick="boardSearch()">등록</button></td>
				</tr>
			</form>
		</thead>
		
		<tbody>
			<div id="comment_list">
			
				<tr>
					<td>작성자</td>
					<td>작성날짜</td>
					<td>작성내용</td>
				</tr>
				
				<%for(ReplyVO rvo : list){ %>
				<div>
				<tr>
					<td><%=rvo.getNICK() %></td>
					<td><%=rvo.getWRITE_DATE() %></td>
					<td><%=rvo.getREPLY_CONTENT() %></td>
				</tr>
				</div>
					
				<%} %>
			</div>
		</tbody>
		</table>
	</div>
		
</body>
</html>