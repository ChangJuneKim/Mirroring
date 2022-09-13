use world;

select *
from countrylanguage;

select *
from country;

select *
from city;


#1
select co.code, co.name
from city c
         join country co
              on co.code = c.CountryCode
where c.name = 'kabul';

#2
select c.name, l.Language, l.Percentage
from country c
         join countrylanguage l
              on c.Code = l.CountryCode
where l.Percentage = 100
  and l.IsOfficial = 'T'
order by c.name;

#3
select ci.name, cl.Language, co.name
from city ci
         join country co
              on ci.CountryCode = co.Code
         join countrylanguage cl
              on cl.CountryCode = co.Code
where ci.Name = 'Amsterdam'
  and cl.IsOfficial = 'T';

#4
select co.Name, co.Capital, ci.name, ci.Population
from city ci
         join country co on ci.id = co.Capital
where lower(co.Name) like 'united%';

#5
select co.Name, co.Capital, ifnull(ci.name, '수도없음') 수도, ifnull(ci.Population, '수도없음') 수도인구
from city ci
         right outer join country co on ci.id = co.Capital
where lower(co.Name) like 'united%';

#6
select count(*)
from country co
         join countrylanguage l on co.Code = l.CountryCode
where l.Percentage > (select max(Percentage)
                      from countrylanguage
                      where CountryCode = 'che')
  and IsOfficial = 'T';

#7
select l.Language
from countrylanguage l
         join country c on l.CountryCode = c.Code
where c.name = 'south korea'
  and IsOfficial = 'T';

select *
from country;

#8
select co.name,
       co.code,
       (case
            when count(co.code) = 1 then '단독'
            else count(co.code)
           end) as '도시개수'
from country co
         join city ci on co.Code = ci.CountryCode
where co.Name like 'bo%'
group by co.name;

#9
select co.name,
       co.code,
       (IF(count(co.code) = 1, '단독', count(co.code))) as '도시개수'
from country co
         left outer join city ci on co.Code = ci.CountryCode
where co.Name like 'bo%'
group by co.name;

#10
select CountryCode, name, Population
from city
where Population = (select max(Population)
                    from city);

#11
select co.name, ci.CountryCode, ci.name, ci.Population
from city ci
         join country co on ci.CountryCode = co.Code
where ci.Population = (select min(Population)
                       from city);

#12
select CountryCode, name, Population
from city
where Population > (select Population
                    from city
                    where name = 'seoul');

# 먼저 KOR의 seoul의 인구를 찾아야 한다.
select population
from city
where countrycode = 'KOR'
  and name = 'seoul';
# 위 sub query를 이용해 main query 를 작성한다.
select countrycode, name, population
from city
where population > (select population from city where countrycode = 'KOR' and name = 'seoul');

#13
select ci.CountryCode, cl.Language
from city ci
         join countrylanguage cl on ci.CountryCode = cl.CountryCode
where ci.Name = 'San Miguel'
  and cl.IsOfficial = 'T';

# 다중행 sub query를 이용한다.
# 먼저 san miguel이 어떤 나라에 있는지 확인이 필요하다.
select countrycode
from city
where name = 'san miguel';
# 총 3건의 row가 반환된다.
# 이제 이 나라들의 공식 언어를 살펴보자.
select countrycode, language
from countrylanguage
where countrycode in (select countrycode
                      from city
                      where name = 'san miguel')
  and isOfficial = 'T';


#14
select ci.CountryCode, max(ci.Population)
from city ci
group by ci.CountryCode
order by ci.CountryCode;

#15
select ci.CountryCode, ci.name, max(ci.Population)
from country co
         join city ci on co.Code = ci.CountryCode
group by CountryCode
order by CountryCode;

select countrycode, name, population
from city
where (countrycode, population) in (select countrycode, max(population) from city group by countrycode)
order by countrycode;

#16
select co.code, co.name, t.name, t.population
from country co
         left outer join (select countrycode, name, population
                          from city
                          where (countrycode, population) in
                                (select countrycode, max(population)
                                 from city
                                 group by countrycode)) t on co.code = t.countrycode;

#17
create or replace view summary
as
select co.code, co.name "co_name", t.name "ci_name", t.population
from country co
         left join (select countrycode, name, population
                    from city
                    where (countrycode, population) in
                          (select countrycode, max(population) from city group by countrycode)) t
                   on co.code = t.countrycode;

# 18
# view에서 조회할 때는 일반적인 테이블을 사용하는 것과 동일하다.
select *
from summary
where code = 'kor';