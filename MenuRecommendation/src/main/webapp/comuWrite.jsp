<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>

			<div id = "board">
				<form action="WriteService" method="post" enctype="multipart/form-data">
				<table id="list">
					<tr>
						<td>����</td>
						<td><input name="title" type="text" >
							<%-- value��(��) <%= %>�� �г��� �ֱ� --%>
							<input name="writer" type="hidden" value="aaa">
							<%-- value��(id) <%= %>�� id �ֱ� --%>
							<input name="id" type="hidden" value="yj1">
						</td>
					</tr>
					<tr>
						<td colspan="2">����</td>
					</tr>
					<tr>
						<td colspan="2">
							<input id="file" name="file" type="file" style="float: right;">
							<textarea name="content" rows="10" style="resize: none;"></textarea>			
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="reset" value="�ʱ�ȭ">
							<input type="submit" value="�ۼ��ϱ�">
						</td>
					</tr>
				</table>
				</form>
			</div>
			
			<script>
				if($("#file").val()!=null){
				$("form").attr("enctype","multipart/form-data");
				}
			</script>
</body>
</html>