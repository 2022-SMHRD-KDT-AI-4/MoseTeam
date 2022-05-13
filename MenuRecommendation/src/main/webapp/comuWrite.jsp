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
						<td>제목</td>
						<td><input name="title" type="text" >
							<%-- value값(닉) <%= %>로 닉네임 넣기 --%>
							<input name="writer" type="hidden" value="aaa">
							<%-- value값(id) <%= %>로 id 넣기 --%>
							<input name="id" type="hidden" value="yj1">
						</td>
					</tr>
					<tr>
						<td colspan="2">내용</td>
					</tr>
					<tr>
						<td colspan="2">
							<input id="file" name="file" type="file" style="float: right;">
							<textarea name="content" rows="10" style="resize: none;"></textarea>			
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="reset" value="초기화">
							<input type="submit" value="작성하기">
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