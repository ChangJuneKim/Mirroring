use world;

#1
select date(now()) as '오늘', dayofyear(now()) as '올해 지난 날', date(date_add(now(), INTERVAL 100 day)) as '100일 후';

#2
select name, Continent, LifeExpectancy,
       case
           when LifeExpectancy > 80 then '장수국가'
           when LifeExpectancy > 60 then '일반국가'
           else '단명국가'
           end as '구분'
from country
where Continent = 'asia'
order by LifeExpectancy;

#3
select name, gnp, GNPOld,
       case
           when isnull(GNPOld) then '신규'
           else gnp-GNPOld
           end as 'gnp 향상'
from country
order by name;

#4
select weekday('2020-05-05'),
    case
        when weekday('2020-05-05') = 1 then '행복'
        when weekday('2020-05-05') = 7 then '행복'
        else '불행'
        end as '행복여부';

#5
select count(*) as '전체', count(IndepYear) as '독립 연도 보유'
from country;

#6
select sum(LifeExpectancy) as '합계', round(avg(LifeExpectancy), 2) as '평균',max(LifeExpectancy) as '최대',min(LifeExpectancy) as '최소'
from country;

#7
select Continent, count(*) as '국가 수', sum(Population) as '인구 합'
from country
group by Continent
order by count(*) desc;

#8
select Continent, sum(SurfaceArea)
from country
group by Continent
order by sum(SurfaceArea) desc
limit 3;

#9
select Continent, sum(gnp) as 'gnp 합'
from country
where Population >= 50000000
group by Continent
order by sum(gnp);

#10
select Continent, sum(gnp) as 'gnp 합'
from country
where Population >= 50000000
group by Continent
having sum(gnp) >= 5000000
order by sum(gnp);

#11
select IndepYear, count(IndepYear) as '독립 국가 수'
from country
group by IndepYear
having  IndepYear is not null
order by count(IndepYear) desc;

#12 -- 이게 맞는지는 모르겠음..
select Continent, name, gnp, avg(gnp) over() as '전세계 평균',  avg(gnp) over (partition by Continent)  as '대륙별 평균'
from country;
