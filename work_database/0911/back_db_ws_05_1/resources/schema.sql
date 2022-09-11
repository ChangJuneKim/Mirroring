-- DB 제공파일

DROP DATABASE IF exists ssafy_car;

CREATE DATABASE ssafy_car CHARACTER SET=utf8;

USE ssafy_car;

DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS manufacturer;

CREATE TABLE `car` (
	`vin` varchar(45) NOT NULL PRIMARY KEY,
    `modelname` varchar(40) NOT NULL,
    `date_of_manufacture` date,
    `mileage` int NOT NULL,
    `manufacturer_code` int NOT NULL
)ENGINE=InnoDB;

CREATE TABLE `manufacturer` (
	`code` int NOT NULL PRIMARY KEY,
    `company_name` varchar(40) NOT NULL,
    `nation` varchar(40) NOT NULL
)ENGINE=InnoDB;

INSERT INTO `car` (vin, modelname, date_of_manufacture, mileage, manufacturer_code)
VALUES 
('KMHXX00XXXX000000', '소나타', '2018-05-01', 20000 ,100),
('KMHXX00XXXX000001', '아반떼', '2021-12-25', 1000, 100),
('KNHXX00XXXX000000', 'K-5' ,'2017-12-10', 35000,200),
('KNHXX00XXXX000001', '쏘렌토','2010-08-01', 100000,200),
('1G1ZE5ST1HF199624', '말리부','2020-01-10', 5000, 300);

INSERT INTO `manufacturer` (code, company_name, nation)
VALUES
(100, '현대자동차', 'KOR'),
(200, '기아자동차', 'KOR'),
(300, '쉐보레', 'USA'),
(400, '포드', 'USA');

-- 아래부터 문제 
USE ssafy_car;


# 1. car 테이블 내의 전체 데이터를 조회하시오.
SELECT *
FROM car;
    
# 2. car 테이블 내의 모든 modelname을 조회하시오.
SELECT modelname
FROM car;

# 3. car 테이블 내의 전체 자동차를 mileage 가 큰것부터 (내림차순) 조회하시오.
SELECT *
FROM car
order by mileage desc;
    
# 4. modelname이 '소나타' 인 자동차 정보를 조회하시오.
SELECT *
FROM car
WHERE modelname = '소나타';
    
# 5. vin이 'K' 로 시작하는 자동차 정보를 조회하시오.
SELECT *
FROM car
WHERE vin like 'K%';

# 6. vin에 'MH' 이 포함되는 자동차 정보를 조회하시오.
SELECT *
FROM car
WHERE vin like '%MH%';
    

# 7. modelname ‘소나타’ 또는 ‘K-5’ 인 자동차의 정보를 조회하시오.
SELECT *
FROM car
WHERE modelname = '소나타' or modelname = 'K-5';

# 8. mileage 30000 이상인 자동차중 modelname이 ‘소나타’ 또는 ‘K-5’ 인 자동차의 정보를 조회하시오.
SELECT *
FROM car
WHERE mileage >= 30000
        and (modelname = '소나타' or modelname = 'K-5');
	
# 9. 'TOLOWERCASE' 를 모두 소문자로 바꿔서 출력하시오.
SELECT lower('TOLOWERCASE') AS '소문자' FROM DUAL;

# 10. '소나타' , '하이브리드' 두 단어를 연결해서 출력하시오.
SELECT concat('소나타', '하이브리드') AS '연결' FROM DUAL;

# 11. date_of_manufacture가 2018년 5월 1일 이후인 자동차들의 vin 맨 앞 두글자와 자동차 정보를 조회하시오.
SELECT *, substring(vin, 1, 2) AS '부분문자열'
FROM car
WHERE date_of_manufacture > '2018-05-01';

# 12. modelname이 ‘K-5’인 자동차의 modelname을 'K-3'로 바꾼후 조회하시오.
SELECT replace(modelname, '5', '3') AS '문자열 바꾸기'
FROM car
WHERE modelname = 'K-5';
