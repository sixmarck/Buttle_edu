drop table dqTest cascade constraint;

create table dqTest(
	id varchar2(10) primary key,
	age number(3) not null
);

insert into dqTest values('master', 10);
insert into dqTest values('test', 20);
insert into dqTest values('coffee', 30);
insert into dqTest values('doll', 40);
commit;