<%@page import="MT.model.HistoryVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script src="js/modernizr-custom.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/ResHis.css" />
<title>Insert title here</title>
</head>
<body>
	<div class='Header'>
		<h2>�Ĵ� �湮 ����</h2>
	</div>
	<div class='Nav'>
		<tr>
			<td align="right">�˻� �Ⱓ :
				<form action="HistoryService" method="Post" onchange="this.form.submit()">
					<select name="month">
						<option value="1">1����</option>
						<option value="2">3����</option>
						<option value="3">6����</option>
					</select>
				</form>
			</td>
			<td colspan="3"><input name="search" type="text"></td>
			<td align="right"><input type="submit" name="btnSearch" value="�˻�"></td>
		</tr>
	</div>

	<%
		List<HistoryVO> hisList = (List<HistoryVO>)request.getAttribute("hisList");
		if (hisList != null) {
			for (int i = 0; i < hisList.size(); i++) {
	%>
		<div class="select_res">
			<div class="mark"></div>
			<button class="btnS" id="bad">�Ⱦ��</button>
			<button class="btnS" id="good">���ƿ�</button>
			<button class="btnS" id="rv" onclick=<%="revv"+i+"()" %>>�ı�</button>
	
			<div class="sel">
				<span><%=hisList.get(i).getRest_nm() %></span>
				<span><%=hisList.get(i).getEnter_date() %></span>
			</div>
			<div id=<%="review" + i%>>
				<tr>
	
				</tr>
			</div>
	</div>
	<%
	}
	}
	%>

</body>
<script src="js/reviewHis.js"></script>
</html>