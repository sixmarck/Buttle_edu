drop table joinPerson cascade constraint;
drop table joinHobbys cascade constraint;


create table joinPerson(
	id varchar(10) constraint joinPerson_id_pk primary key,  
	name varchar2(10));

create table joinHobbys(
	hobby varchar2(10) not null, 
	id varchar2(10) constraint joinHobbys_id_fk references joinPerson(id));

insert into joinPerson values('javaman', '최성식');

insert into joinHobbys values('독서', 'javaman');
insert into joinHobbys values('게임', 'javaman');
insert into joinHobbys values('운동', 'javaman');

commit;
