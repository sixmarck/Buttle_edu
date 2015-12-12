drop table account cascade constraint;

create table account(
	acc_id number(3),
	acc_first_name varchar2(20),
	acc_last_name varchar2(20),
	acc_email varchar2(40)
);

insert into account values(1,'master','kim','master@gmail.com');

commit;

