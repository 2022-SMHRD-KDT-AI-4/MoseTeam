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
			<h2 class="text-center">�Խñ� ����</h2>
			<p>&nbsp;</p>
			<div class="table table-responsive">
				<table class="table">
					<tr>
						<th class="success">�۹�ȣ</th>
						<td><%=vo.getBOARD_NO() %></td>
						<th class="success">��õ��</th>
						<td><%=vo.getGOOD() %></td>
						<td>
						<a href="GoodAddService?num=<%=vo.getBOARD_NO() %>"><button>��õ�ϱ�</button></a>
						</td>
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

					<tr>
						<td colspan="4" class="text-center">
							<%-- ����ۼ� �̿ϼ� --%>
							<input type="button" class="btn btn-wirte" value="��� ����"
							onclick="location.href='BoardReWriteForm.jsp?num=  &ref=  &ref_step=  &ref_level='">
							
							<a href="BEditLoadService?num=<%=vo.getBOARD_NO() %>"><button>�����ϱ�</button></a>
							
							<a href="BDeleteService?num=<%=vo.getBOARD_NO() %>"><button>�����ϱ�</button></a>
							
							<a href="ListService"><button>��Ϻ���</button></a>
							
						</td>
					</tr>
					<tr>�Ű��ư �� �߰� �����</tr>
					<tr>�����°���</tr>
	<div id = "form-commentInfo">
		<div id = "comment-count"> ��� <span id ="count">0</span></div>
		<input id = "comment-input" placeholder="����� �Է��� �ּ���.">
		<button id = "submit">���</button>
	</div>
	<div id = comments>
	</div>
	<script src="./comment.js"></script>
</body>
</html>