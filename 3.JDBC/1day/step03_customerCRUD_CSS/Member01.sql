drop table Member01;
create table Member01 (
	id varchar2(12) primary key,
	pw varchar2(12) not null,
	name varchar2(12) not null,
	memDate Date default sysdate
);

insert into Member01 values('aaa', 'aaa', 'ȫ�浿', default);
insert into Member01 values('bbb', 'bbb', '��ö��', default);
insert into Member01 values('ccc', 'ccc', '�迵��', default);
commit;