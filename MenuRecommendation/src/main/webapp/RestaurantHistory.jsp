<%@page import="MT.model.HistoryVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=EUC-KR"
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
	<script>let flag = "parent"</script>
	<div class='Header'>
		<h2>�Ĵ� �湮 ����</h2>
	</div>
	<div class='Nav'>
	<table>
		<tr>
			<td> �˻� �Ⱓ : </td>
			<td>
				<form action="HistoryService" method="Post" onchange="this.form.submit()">
					<select name="month">
						<option value="1">1����</option>
						<option value="2">3����</option>
						<option value="3">6����</option>
					</select>
				</form>
			</td>
			<!--  <td colspan="2"><input name="search" type="text"></td>
			<td align="right"><input type="submit" name="btnSearch" value="�˻�"></td>-->
		</tr>
	</table>
	</div>

	<%
		List<HistoryVO> hisList = (List)request.getAttribute("hisList");
		if (hisList != null) {
			for (int i = 0; i < hisList.size(); i++) {
	%>
		<div class="select_res">
			<%-- <button class="btnS" id="bad">�Ⱦ��</button>
			<button class="btnS" id="good">���ƿ�</button>
			<button class="btnS" id="rv" onclick= "revv1()">�ı�</button> --%>
			
			<form action = "HistoryUpdateService" method = "POST" name = "reviewUpdate">
			<div class="sel">
				<span class = "restName"><%=hisList.get(i).getRest_nm() %></span>
				<span class = "restCate"><%=hisList.get(i).getSub_cate() %></span>
				<span class = "enterDate"><%=hisList.get(i).getEnter_date() + "�Ͽ� �湮" %></span>
				<!-- ��������� hidden input -->
				<input type = 'hidden' name = "review_no" value = <%=hisList.get(i).getReview_no() %>>
				<div class = "reviewDetail">	
					<hr>
					<div class = "rateWrap" value = "review_level">
						<div class = "rate" name = "3" value ="none">���ƿ�</div>
						<div class = "rate" name = "2" value ="none">�����̿���</div>
						<div class = "rate" name = "1" value ="none">���ο���</div>
					</div>
					<div class = "btnWrap">
						<input type = "submit" name="action" value="Update">
						<input type = "submit" name="action" value="Delete">
					</div>
					<div class = 'reviewContent'>
						<textarea name = "review_content" rows="3" cols="75">
						<%=hisList.get(i).getReview_content() != null? hisList.get(i).getReview_content(): "" %>
						</textarea>
					</div>
				</div>
			</div>
			<%--  <div id=<%="review" + i%>><tr></tr></div>--%>
			</form> 
		</div>
	<%
		}
	}
	%>

</body>
<script src="js/reviewHis.js"></script>
<script type ="text/javascript">
	// ������� �ۼ��߿� â�� �ݱ��� �ʵ��� ��
	$('.reviewDetail').on('click', function() {
		console.log("reviewDetail")
		flag = "child"
	});
	
	$('.sel').on('click', function() {
		console.log("sel")
		console.log(flag)
		if(flag == "child"){
			// �ڽ� ��ҿ��� ȣ��� ����X
			flag = parent;
			return;
		}
		var review = this.getElementsByClassName('reviewDetail')
		if(review[0].style.display == 'block'){
			review[0].style.display = 'none';
			this.style.height = "55px"
		}else{
			review[0].style.display = 'block';
			this.style.height = "150px"
		}
	});
	//$('.reviewEmpty > a').on('click',function(){
	//	console.log('Ŭ��')
	//	var url = "review.jsp";
    //    var name = "Review Write";
    //    var option = "width = 500, height = 500, top = 100, left = 200, location = centor"
    //    window.open(url, name, option);
	//})

</script>
</html>