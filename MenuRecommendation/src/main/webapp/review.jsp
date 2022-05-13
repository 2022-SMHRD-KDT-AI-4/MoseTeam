<!DOCTYPE html>
<%@page import="MT.model.ReviewVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>후기</title>
    <link rel="stylesheet" href="css/review.css"/>
    <script type="text/javascript" src="js/review.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>

	<%
		ReviewVO vo = (ReviewVO)request.getAttribute("rvo");
	%>

    <div class="wrap">
        <h1>후기</h1>
        <form name="reviewform" class="reviewform" method="post" action="ReviewService" target="close">
            <input type="hidden" name="resrId" value="1"/>
            <input type="hidden" name="memberId" value="yj1"/>
            <input type="hidden" name="rate" id="rate" value="0"/>
            <p class="title_star">음식은 어땠나요??</p>
     
            <div class="review_rating rating_point">
                <div class="warning_msg">어땠는지 말씀해주세요~~</div>
                <div class="rating">
                    <div class="ratefill"></div>
                    <!-- [D] 해당 별점이 선택될 때 그 점수 이하의 input엘리먼트에 checked 클래스 추가 -->
                    <!-- review_level 싫어요(1), 좋아요(2) -->
                    <button type="button" class="btnS" id="bad" value="1">싫어요</button>
                    <button type="button" class="btnS" id="good" value="2">좋아요</button>   
                    
                </div>
            </div>
            <div class="review_contents">
                <div class="warning_msg">한글자 이상 작성!</div>
                <textarea rows="10" class="review_textarea" name="text"></textarea>
            </div>   
            <div class="cmd">
                <input type="button" name="save" id="save" value="등록">
            </div>
                <input type="button" name="close1" id="close1" value="창 닫기">
        </form>
    </div>
    <script>
    	$("#bad").click(function(){
    		$("#rate").val("1");
    	});
    	$("#good").click(function(){
    		$("#rate").val("2");
    	});
    </script>
    <script>
    	$("#save").click(function(){
    		if(($("#rate").val()!=0)&&($(".review_textarea").val()!="")){
    			$("#save").prop("type","submit");
    			setTimeout(function(){
    			window.close();
    			},100);
    		};
    	});
    </script>
</body>
    <iframe id="close" name="close" style="display:none"></iframe>
</html>