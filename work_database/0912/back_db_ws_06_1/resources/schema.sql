USE ssafy_car;

SELECT 
    *
FROM
    car;

# 1.	car 테이블에 전채 몇개의 행이 있는지 조회하시오.
SELECT count(*) AS '차량 수' FROM car;

# 2.	전체 차량의 mileage 평균을 조회하시오.
SELECT avg(mileage) AS '평균' FROM car;

# 3.	전체 차량의 mileage 합을 조회하시오.
SELECT sum(mileage) AS '총합' FROM car;

# 4.	mileage가 20000 이하인 차량의 mileage 평균을 둘째짜리 까지 반올림 하여 조회하시오.
SELECT 
    round(avg(mileage), 2) AS '평균'
FROM
    car
WHERE
    mileage <= 20000;

# 5.	manufacturer_code 로 그룹핑 했을때 각 그룹에 몇개의 차량이 포함되어 있는지 조회하시오.
SELECT 
    manufacturer_code, count(*) AS '개수'
FROM
    car
group by manufacturer_code;

# 6.	manufacturer_code 로 그룹핑 했을때 각 그룹의 제일 빠른 date_of_manufacture를 조회하시오
SELECT 
    manufacturer_code, min(date_of_manufacture) AS '날짜'
FROM
    car
group by manufacturer_code;

# 7.	manufacturer_code 로 그룹핑 했을때 각 그룹의 제일 긴 mileage가 얼마인지 조회하시오. 
SELECT 
    manufacturer_code, max(mileage) AS '최대'
FROM
    car
group by manufacturer_code;

# 8.	manufacturer_code 로 그룹핑 했을때 mileage의 평균이 20000 이상인 그룹의 manufacturer_code를 조회하시오.
SELECT 
    manufacturer_code, avg(mileage) AS '평균'
FROM
    car
group by manufacturer_code
having avg(mileage) >= 20000;

# 9.	manufacturer_code 로 그룹핑 했을때 mileage의 합이 20000 이상인 그룹의 manufacturer_code를 조회하시오.
SELECT 
    manufacturer_code, sum(mileage) AS '총합'
FROM
    car
group by manufacturer_code
having max(mileage)>= 20000;

# 10.	manufacturer_code 로 그룹핑 했을때 mileage의 평균이 20000 이상인 그룹들 중 mileage의 총 합이 20000 이상인 그룹의 manufacturer_code를 조회하시오.
SELECT 
    manufacturer_code,
    avg(mileage) AS '평균',
    sum(mileage) AS '총합'
FROM
    car
group by manufacturer_code
having avg(mileage) >= 20000
   and sum(mileage) >= 20000;
