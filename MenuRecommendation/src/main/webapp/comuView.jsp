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
						<th class="success">��ȸ��</th>
						<td><%-- ��ȸ�� ���ۼ� --%></td>
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
</body>
</html>