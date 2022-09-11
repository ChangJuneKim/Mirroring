
#1 sakila 데이터베이스를 사용하도록 설정하시오
use sakila;

#2 file 테이블에서 rental_duration이 7이상인 film의 film_id와 title을 조회하시오.(191건)
select film_id, title
from film
where rental_duration >= 7;

#3 film 테이블에서 rental_rate가 4이상인 film에 대해 length의 오름차순으로 정렬하시오.(336건)
select *
from film
where rental_rate >= 4
order by length;

#4 film 테이블에서 rating을 중복없이 조회하시오.
select distinct rating
from film;

#5 rental 테이블에서 inventory_id가 367인 데이터를 조회하시오.
select *
from rental
where inventory_id = 367;

#6 rental 테이블에서 5개의 데이터만 출력하시오.
select *
from rental
limit 5;

#7 rental 테이블에서 rental_date가 2005년 5월 24일 23시 이전인 데이터의 inventory_id를 조회하시오.
select inventory_id
from rental
where rental_date < '2005-05-24 23:00:00';

#8 actor 테이블에서 last_update가 가장 최근인 시간을 하나만 조회하시오
select last_update
from actor
order by last_update
limit 1;

#9 actor 테이블에서 first_name이 'Z'로 시작하는 배우를 조회하시오
select *
from actor
where first_name like 'Z%';

#10 actor 테이블에서 actor_id가 10이하이고 last_name에 "C"가 들어가는 배우를 조회하시오
select *
from actor
where actor_id <= 10 and last_name like "%C%";

#11 actor 테이블에서 first_name과 last_name이 각각 5글자인 배우를 3개의 데이터만 조회하시오.
select *
from actor
where length(first_name)=5 and length(last_name)=5
limit 3;

#12 actor 테이블에서 actor_id가 25인 배우의 first_name을 뒤집어서 출력하시오.
select reverse(first_name)
from actor
where actor_id = 25;

#13 concat을 활용해서 "제가 제일 좋아하는 배우는 first_name, last_name입니다"라는 문장을 실행해보자.
#   배우의 이름은 actor 테이블에 있는 어떤 배우를 사용해도 좋다.

select concat('제가 제일 좋아하는 배우는 ',first_name, ' ', last_name,'입니다')
from actor;