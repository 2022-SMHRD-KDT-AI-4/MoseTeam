select * from member

select * from member
		where MEMBER_ID = 'test'
		and MEMBER_PW = '1234'
		
		

select * from BOARD

alter table board add  writer  varchar(40) not null;
		   
drop view comu
		   

		   
select * from COMU


create SEQUENCE board_seq
start with 1
increment by 1
maxvalue 10000;

drop sequence borad;


select * from board_seq

board_seq.nextval;
board_seq.board;