select * from member

select * from member
		where MEMBER_ID = 'test'
		and MEMBER_PW = '1234'
		
select * from BOARD

select * from COMU

alter table BOARD modify FILE_NAME;

insert into board values(board_seq.nextval, 'aa','aa','yj1',sysdate,null,'aaa')

select * from REVIEW
select rest_id from RESTAURANT

select * from PUSH

update board set good = board.good + 1
where board_no = 22

select count(*) from push
		where BOARD_NO = 23
		and MEMBER_ID = 'yj1'





