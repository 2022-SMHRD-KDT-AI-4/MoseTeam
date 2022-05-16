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
<link rel="stylesheet" href="css/comuView.css?ver=2">
<link rel = "stylesheet" href="https://stackpath.bootstranpcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
@import url('https://fonts.googleapis.com/css2?family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Gugi&family=Stylish&display=swap');
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		BoardVO vo = (BoardVO)request.getAttribute("bvo");
		List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("list");
		int count = Integer.parseInt(String.valueOf(request.getAttribute("count")));
	%>
	
	
	<div class="row">
		<div class="col-xs-2 col-md-2"></div>
		<div class="col-xs-8 col-md-8">

			<div class="table table-responsive">
				<table class="table" border="2" cellspacing="0">
					<tr>
						<th class="success">�۹�ȣ</th>
						<td><%=vo.getBOARD_NO() %></td>
						<th class="success">��õ��</th>
						<td><%=vo.getGOOD() %><button class="chu" onclick="location.href='GoodAddService?num=<%=vo.getBOARD_NO() %>'">��õ</button></td>

					</tr>


					<tr>
						<th class="success">�ۼ���</th>
						<td><%=vo.getWRITER() %></td>
						<th class="success">�ۼ���</th>
						<td><%=vo.getWRITE_DATE() %></td>
					</tr>

					<tr>
						<th class="success">����</th>
						<td colspan="3"><%=vo.getBOARD_TITLE() %></td>
					</tr>
					<tr>
						<th class="success">�� ����(�̹���)</th>
						<td colspan="3">
						<img alt="" src="comuFileImg/<%=vo.getFILE_NAME() %>"></td>
					</tr>
					
					<tr>
						<th class="success">�� ����(�ؽ�Ʈ)</th>
						<td colspan="3"><%=vo.getBOARD_CONTENT() %></td>
					</tr>

				</table>	
					<tr>
							<td colspan="4" class="text-center">

							<input type="button" class="btn" id="btn-primary" value="��Ϻ���"
							onclick="location.href='http://localhost:8081/MenuRecommendation/ListService'">
							
							<input type="button" class="btn" id="btn-danger" value="�����ϱ�"
							onclick="location.href='BoardDeleteForm.jsp?num=<%=vo.getBOARD_NO() %>'">
							
							<input type="button" class="btn" id="btn-warning" value="�����ϱ�"
							onclick="location.href='BoardUpdateForm.jsp?num=<%=vo.getBOARD_NO() %>'">
						
							<input type="button" class="btn" id="btn-report" value="�Ű��ϱ�"
							onclick="location.href='BadReportService?num=<%=vo.getBOARD_NO() %>'"></td>
					</tr>	
	</div>			
	<div id="comment">
		<table>
		<thead>
			<form action="CommentService" method="get" class="addComment">
				<tr>
					<div> ���<span id ="count"><%=count %></span>
				</tr>
				<tr>
					<td colspan="3"><input class="input" name="comment" type="text" placeholder="����� �Է��� �ּ���." ></td>
					<td colspan="3"><input name="bodnum" type="hidden" value="<%=vo.getBOARD_NO()%>"></td>
					<td colspan="3"><input name="id" type="hidden" value="yj1<%-- ���� ID --%>"></td>
					<td colspan="3"><input name="nick" type="hidden" value="test<%-- ���� ID �г��� --%>"></td>
					<td align="left"><button class="btn1" type="submit" onclick="boardSearch()">���</button></td>
				</tr>
			</form>
		</thead>
		
		<tbody>
			<div id="comment_list" >
				<table class="table" border="2" cellspacing="0">
				<tr class="head">
					<td>�ۼ���</td>
					<td>�ۼ�����</td>
					<td>�ۼ���¥</td>
				</tr>
				
				<%for(ReplyVO rvo : list){ %>
				<div>
				<tr>
					<td><%=rvo.getNICK() %></td>
					<td><%=rvo.getREPLY_CONTENT() %></td>
					<td><%=rvo.getWRITE_DATE() %></td>
				</tr>
				</div>
					
				<%} %>
				</table>
			</div>
		</tbody>
		</table>
	</div>
		
</body>
</html>