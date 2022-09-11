# 1. world 데이터베이스를 사용하도록 설정하시오.
use world;

# 2. city, country, countrylanguage 테이블의 구조를 파악하시오.
# 테이블의 구조를 확인하기 위해 desc 명령을 사용한다.
desc city;
desc country;
desc countrylanguage;

# 3. country table에서 code가 KOR인 자료를 조회하시오.
# 모든 컬럼을 조회하려는 경우 *를 사용한다.
select * from country where code='KOR';

# 4. country에서 gnp변동량(gnp-gnpold)이 양수인 국가에 대해 아래 형식으로 출력하시오.
# 컬럼의 헤더를 변경하기 위해서 alias를 사용할 수 있다.
select code, name, gnp, gnpold , gnp-gnpold "gnp변동량" from country where gnp-gnpold >0;

# 5. country table에서 continent를 중복 없이 조회하시오.
# distinct 를 이용하면 중복 자료를 제거할 수 있다.
select distinct(continent) from country;

# 6. country에서 asia 대륙에 속하는 국가들의 정보를 아래와 같이 출력하시오.
# mysql에서 문자열을 열결할 경우는 concat 함수를 사용한다.
select concat(name,'은 ', region,'에 속하며 인구는 ', population,'명이다.') "정보" from country where continent='asia';

# 7. country에서 독립 년도에 대한 기록이 없고 인구가 10000이상인 국가의 정보를 아래와 같이 인구의 오름차순으로 출력하시오.
# 값이 null인지 확인할 경우 is null을 사용한다. 또한 and or를 이용해서 여러 조건을 복합적으로 사용할 수 있다.
select name, continent, gnp, population from country where indepyear is null and population >=10000 order by Population;

# 8. country에서 인구가 1억<=x<=2억 인 나라를 인구 기준으로 내림차순 정렬해서 상위 3개만 출력하시오.
select code, name, Population from country where Population between 100000000 and 200000000 order by 3 desc limit 3;

# 9. country에서 800, 1810, 1811, 1901, 1901에 독립한 나라를 독립년 기준으로 오름차순 출력하시오. 단 독립 년이 같다면 code를 기준으로 내림차순 한다.
select code, name, indepyear from country where indepYear in(800,1810, 1811,1901) order by 3, 1 desc;

# 10. country에서 region에 asia가 들어가고 name의 두 번째 글자가 o인 정보를 출력하시오.
select code, name, region from country where region like '%asia%' and name like '_o%';

# 11. '홍길동'과 'hong'의 글자 길이를 각각 출력하시오.
select char_length('홍길동') "한글", char_length('hong') "영문";

# 12. country에서 governmentform에 republic이 들어있고 name의 길이가 10 이상인 자료를 이름의 길이 내림차순으로 상위 10개만 출력하시오.
select code, name, governmentform from country where char_length(name)>=10 and instr(governmentform, 'republic') order by char_length(name) desc limit 10;

# 13. country에서 code가 모음으로 시작하는 나라의 정보를 보기처럼 출력하시오.  이때 name의 오름차순으로 정렬하고 3번 부터 3개만 출력한다.
select code, name from country where substr(code, 1, 1) in ('a', 'e','i','o','u') order by name limit 2, 3;

# 14. country에서 name을 맨 앞과 맨 뒤에 2글자를 제외하고 나머지는 *로 처리해서 출력하시오.
select name, concat(left(name, 2), lpad('*', char_length(name)-4, '*'), right(name, 2)) 'guess' from country;

# 15. country에서 region을 중복 없이 가져오는데 공백을 _로 대체하시오. 
select distinct(replace(region, ' ', '_')) "지역들" from country order by length(region) desc;

# 16. country에서 인구가 1억 이상인 국가들의 1인당 점유면적(surfacearea/population)을 반올림해서 소숫점 3자리로 표현하시오. 1인당 점유 면적의 오름차순으로 정렬한다.
select name, surfacearea, population, round(surfacearea/population, 3) '1인당 점유면적' from country where population >=100000000 order by 2;