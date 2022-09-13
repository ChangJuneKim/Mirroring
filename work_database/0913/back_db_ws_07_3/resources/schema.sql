use world;

select @@autocommit;
set autocommit = false;

select *
from countrylanguage;

# 1. countrylanguage에 countrycode='AAA', language='외계어', isOfficial='F', percentage=10을 추가하시오.
insert into countrylanguage
values ('AAA', '외계어', 'F', 10);
# 값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
-- countrycode는 country 테이블을 참조하는 Foreign Key이므로 country 테이블에 있는 값만 사용할 수 있다.
insert into countrylanguage
values ('KOR', '외계어', 'F', 10);

# 2. countrylanguage에 countrycode='ABW', language='Dutch', isOfficial='F', percentage=10을 추가하시오.
insert into countrylanguage
values ('ABW', 'Dutch', 'F', 10);
-- 값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
-- countrycode와 language가 조합키로 Primary Key를 구성하므로 이미 있는 값은 추가될 수 없다.
insert into countrylanguage
values ('ABW', 'Dutch2', 'F', 10);

# 3. country에 다음 자료를 추가하시오.
# Code='TCode', Region='TRegion',Code2='TC'
insert into country (Code, Region,  Code2) values('TCode', 'TRegion', 'TC');
# 값을 추가할 수 없는 이유를 생각하고 필요한 부분을 수정해서 다시 추가하시오.
-- Code는 최대 3글자만 들어갈 수 있고 name은 not null이고 default가 없으므로 값이 꼭 필요하다.
insert into country (Code, name, Region,  Code2) values('333', 'Tname', 'TRegion', 'TC');

# 4. city에서 id가 2331인 자료의 인구를 10% 증가시킨 후 조회하시오.
update city
set Population = Population * 1.1
where id = 2331;

select *
from city
where id = 2331;

# 5. country에서 code가 'USA'인 자료를 삭제하시오.
delete
from country
where code = 'USA';
# 삭제가 안되는 이유를 생각하고 성공하려면 어떤 절차가 필요한지 생각만 하시오.
-- country의 code는 Foreign Key로 참조되고 있으므로 먼저 참조하고 있는 테이블의 데이터를 삭제후 country 데이터를 삭제해야 한다.

# 6. 이제 까지의 DML 작업을 모두 되돌리기 위해 rollback 처리하시오.
rollback ;

# 7. test_user라는 이름으로 새로운 schema를 생성하시오.
-- schema나 table 등을 생성하기 위해서는 create 명령을 사용한다.
create schema test_user;
use test_user;

# 8. 만약 user라는 테이블이 존재한다면 삭제하시오.
-- schema나 table 등을 삭제하기 위해서는 drop 명령을 사용한다.
drop table if exists user;

# 9. test_user에 다음 조건을 만족하는 테이블을 생성하시오.
# 테이블명: user
-- table을 생성할 때는 create 명령을 사용하며 column을 선언할 때 이름과 타입, 제약사항을 명시할 수 있다.
create table user(
    id varchar(50) primary key,
    name varchar(100) not null default '익명',
    pass varchar(100) not null
);
desc user;

# 10. user 테이블에 다음의 자료를 추가하시오.
# id: ssafy, pass: 1234, name:김싸피
# id: hong, pass: 5678, name:홍싸피
# id: test, pass: test, name:테스트
insert into user
values ('ssafy', '1234', '김싸피'),
       ('hong', '5678', '홍싸피'),
       ('test', 'test', '테스트');

# 11. id가 test인 계정의 pass를 id@pass 형태로 변경하고 조회하시오.
update user
set pass = concat(id, '@', pass)
where id = 'test';
select * from user where id = 'test';

# 12. id가 test인 계정의 자료를 삭제하고 조회하시오.
delete
from user
where id = 'test';
select *
from user;

# 13. 현재까지의 내용을 영구 저장하기 위해서 commit 처리하시오.
commit ;
