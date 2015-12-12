drop table Member01;
create table Member01 (
	id varchar2(12) primary key,
	pw varchar2(12) not null,
	name varchar2(12) not null,
	memDate Date default sysdate
);

insert into Member01 values('aaa', 'aaa', 'È«±æµ¿', default);
insert into Member01 values('bbb', 'bbb', '±èÃ¶¼ö', default);
insert into Member01 values('ccc', 'ccc', '±è¿µÈñ', default);
commit;