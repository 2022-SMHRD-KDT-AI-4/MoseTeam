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
		BoardVO bvo = (BoardVO)request.getAttribute("bvo");
		MemberVO mvo = (MemberVO)request.getAttribute("mvo");
	%>
	<%-- view�� join�ؼ� �ϳ��� ����ϱ� --%>
	
	
	<div class="row">
		<div class="col-xs-2 col-md-2"></div>
		<div class="col-xs-8 col-md-8">
			<h2 class="text-center">�Խñ� ����</h2>
			<p>&nbsp;</p>
			<div class="table table-responsive">
				<table class="table">
					<tr>
						<th class="success">�۹�ȣ</th>
						<td><%=bvo.getBOARD_NO() %></td>
						<th class="success">��ȸ��</th>
						<td><%-- ��ȸ�� ���ۼ� --%></td>
					</tr>


					<tr>
						<th class="success">�ۼ���</th>
						<td><%=mvo.getNICK_NM() %></td>
						<th class="success">�ۼ���</th>
						<td><%=bvo.getWRITE_DATE() %></td>
					</tr>

					<tr>
						<th class="success">����</th>
						<td colspan="3"><%=bvo.getBOARE_TITLE() %></td>
					</tr>

					<tr>
						<th class="success">�� ����</th>
						<td colspan="3"><%=bvo.getBOARD_CONTENT() %></td>
					</tr>
					<tr>
						<td colspan="4" class="text-center">
							<%-- ����ۼ� �̿ϼ� --%>
							<input type="button" class="btn btn-wirte" value="��� ����"
							onclick="location.href='BoardReWriteForm.jsp?num=  &ref=  &ref_step=  &ref_level='">
							
							<a href="BEditService"><button>�����ϱ�</button></a>
							
							<a href="BDeleteService"><button>�����ϱ�</button></a>
							
							<a href="ListService"><button>��Ϻ���</button></a>
							
						</td>
					</tr>
					<tr>�Ű��ư �� �߰� �����</tr>
					<tr>�����°���</tr>
</body>
</html>