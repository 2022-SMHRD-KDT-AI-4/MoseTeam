<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/comuW.css?ver=2">
<style>
@import url('https://fonts.googleapis.com/css2?family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gugi&family=Stylish&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Cute+Font&family=Gugi&family=Stylish&display=swap');
</style>
</head>
<body>

			<div id = "board">
				<form class="form" action="WriteService" method="post" enctype="multipart/form-data">
				<table id="list">
					<tr class="sub">
						<td> &nbsp;제목 &nbsp;:&nbsp;&nbsp;
							<input class="input" name="title" type="text" style="resize: none; width:88.7%; height: 2em; margin:1%">
							
							<input name="writer" type="hidden" value="aaa">
							
							<input name="id" type="hidden" value="yj1">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input id="file" name="file" type="file" style="resize: none; width:30%; margin:1%">		
						</td>
					</tr>
					<tr>
						<td>
							<textarea  name="content" rows="10" style="resize: none; width:98%; margin:1%;"></textarea>	
						</td>
					</tr>
					<tr>
						<td align="center" colspan="2">
							<input class="reset" type="reset" value="초기화" style=" border-radius: 10px; width: 22%; color: #e76d09; border: 3px solid rgb(255, 178, 127); background-color: white; border-radius: 10px; margin:1%; " >
							<input class="write" type="submit" value="작성" style="border-radius: 10px; width: 22%; color: #e76d09; border: 3px solid rgb(255, 178, 127); background-color: white; border-radius: 10px; margin:1%">
							<input class="cancel" type="submit" value="취소" onclick="history.back()" style="border-radius: 10px; width: 22%; color: #e76d09; border: 3px solid rgb(255, 178, 127); background-color: white; border-radius: 10px; margin:1%">
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