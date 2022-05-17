select * from member


select * from BOARD

select * from BOARD

select * from COMU

select * from reply


		select * from review
		where rest_id like '1'
		order by review_NO desc
		
		update restaurant set restcount = restaurant.restcount + 1
		where rest_id = 1
		
select restcount from restaurant


SELECT REST_ID,  REST_NM,  MAIN_CATE,  SUB_CATE
,  REST_ADDR,  702  AS MENU_ID
		  FROM RESTAURANT
		 WHERE REST_ID IN (SELECT DISTINCT B.REST_ID
		  FROM RESTMENU   A
		    ,  RESTAURANT B
		 WHERE A.MENU_ID = 702
		   AND A.REST_ID = B.REST_ID)
		 ORDER BY RESTCOUNT DESC
