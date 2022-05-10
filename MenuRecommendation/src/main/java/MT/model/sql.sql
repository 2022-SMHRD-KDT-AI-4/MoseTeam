select * from member

select * from member
		where MEMBER_ID = 'test'
		and MEMBER_PW = '1234'
		
		

select * from BOARD

alter table BOARD add FILE_NAME varchar(100) not null;


alter table BOARD drop column filename;



create or replace view COMU 
 as select board_no
		   ,board_title 
		   ,board_content 
		   ,member_id
		   ,write_date 
		   ,file_name
		   from BOARD;
		   
		   
		   
select * from COMU