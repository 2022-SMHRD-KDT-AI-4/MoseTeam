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
			<h2 class="text-center">�Խñ� ����</h2>
			<p>&nbsp;</p>
			<div class="table table-responsive">
				<table class="table">
					<tr>
						<th class="success">�۹�ȣ</th>
						<td></td>
						<th class="success">��ȸ��</th>
						<td></td>
					</tr>


					<tr>
						<th class="success">�ۼ���</th>
						<td></td>
						<th class="success">�ۼ���</th>
						<td></td>
					</tr>

					<tr>
						<th class="success">����</th>
						<td colspan="3"></td>
					</tr>

					<tr>
						<th class="success">�� ����</th>
						<td colspan="3"></td>
					</tr>

					<tr>
						<td colspan="4" class="text-center"><input type="button"
							class="btn btn-success" value="��� ����"
							onclick="location.href='BoardReWriteForm.jsp?num=  &ref=  &ref_step=  &ref_level='">
							<input type="button" class="btn btn-warning" value="�����ϱ�"
							onclick="location.href='BoardUpdateForm.jsp?num=  '">
							<input type="button" class="btn btn-danger" value="�����ϱ�"
							onclick="location.href='BoardDeleteForm.jsp?num=  '">
							<input type="button" class="btn btn-primary" value="��Ϻ���"
							onclick="location.href='BoardList.jsp'"></td>
					</tr>
</body>
</html>