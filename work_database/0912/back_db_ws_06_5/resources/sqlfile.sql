use ssafydb;

drop table test;

create table test
(
    val varchar(10)
);

start transaction;

insert into test
values ('a');

insert into test
values ('b');

insert into test
values ('c');

commit ;

select *
from test;

insert into test
values ('d');

insert into test
values ('e');

insert into test
values ('f');

select *
from test;

rollback ;

select *
from test;

select @@autocommit;

set autocommit = 0;