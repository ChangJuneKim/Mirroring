
use ssafy_movie;

select count(*) as '영화 수'
from movie;

select avg(RunningTime) as '평균'
from movie;

select sum(RunningTime) as '총 합'
from movie;

select round(avg(RunningTime), 2) as '포터 평균'
from movie
where Title like '%포터%';

select CinemaCode, count(*) as '수'
from movie
group by CinemaCode;

select CinemaCode, max(RunningTime) as '최대'
from movie
group by CinemaCode;

select CinemaCode, avg(RunningTime) as '평균'
from movie
group by CinemaCode
having avg(RunningTime) >= 150;

select CinemaCode, sum(RunningTime) as '합'
from movie
group by CinemaCode
having sum(RunningTime) >= 300;

select CinemaCode, avg(RunningTime) as '평균',sum(RunningTime) as '합'
from movie
group by CinemaCode
having avg(RunningTime) >= 150 and sum(RunningTime) >= 300;
