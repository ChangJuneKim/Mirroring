use sakila;

#1
select datediff('2022-12-25', now()) as '크리스마스까지 남은 날짜';

#2
select avg(rental_rate), sum(length)
from film;

#3
select count(*)
from rental
where date(return_date) = '2005-06-01';

#4
select film_id, title, description, length
from film
where (length between 60 and 120) and (description like '%robot%')
order by length
limit 10,3;

#5
select rating as '등급', count(film_id) as '영화수', avg(rental_duration) as '평균', max(length) as '최장길이', min(length) as '최단길이'
from film
group by rating;

#6
select customer_id, count(*)
from rental
group by customer_id
order by 2 desc
limit 10;

#7
select avg(replacement_cost) as '평균 가격', avg(rental_rate) as '평균 렌탈 비율'
from film
group by rental_duration;

#8
select sum(replacement_cost)
from film
where rental_duration >= 5;

desc film;

#9
select rating, avg(rental_duration), sum(replacement_cost), avg(length)
from film
where title like 'C%'
group by rating;

