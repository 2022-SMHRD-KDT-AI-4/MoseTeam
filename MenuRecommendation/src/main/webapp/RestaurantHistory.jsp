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
    <div class = 'Header'>
        <h2>�Ĵ� �湮 ����</h2> 
    </div>
    
    <div class = 'Nav'>
        <tr>
        	<td align = "right">
        		�˻� �Ⱓ : 
        		<form action = "HistoryService" method = "Post" onchange="this.form.submit()">
	        		<select name = "month">
	        			<option value = "1">1����</option>
	        			<option value = "2">3����</option>
	        			<option value = "3">6����</option>
	        		</select>
        		</form>
        	</td>
            <td colspan="3"><input name = "search" type="text"></td>
            <td align="right"><input type = "submit" name = "btnSearch" value = "�˻�"></td>
        </tr>
    </div>
   
    <div class="select_res">
    	<div class = "mark"></div>
        <button class="btnS" id="bad">�Ⱦ��</button>
        <button class="btnS" id="good">���ƿ�</button>
        <button class="btnS" id="rv" onclick="revv1()">�ı�</button>
   
        <div class="sel">
            <tr>
                <td>�ؼ� �Ĵ�</td>
                <td>2022-05-11</td>
            </tr>
        </div>
        <div  id="review1" >
            <tr>
                
            </tr>
        </div>
                
    </div>
    <div class="select_res">
        <button class="btnS" id="bad">�Ⱦ��</button><button class="btnS" id="good">���ƿ�</button><button class="btnS" id="rv" onclick="revv2()">�ı�</button>
   
        <div class="sel">
            <tr>
                <td>������ �Ĵ�</td>
                <td>2022-05-5</td>
            </tr>
        </div>
                
        <div id="review2"></div>
    </div>
</body>
<script src="js/reviewHis.js"></script>
</html>