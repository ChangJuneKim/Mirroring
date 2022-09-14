CREATE DATABASE IF NOT EXISTS test_index;
USE test_index;

# 테이블 제약 조건: 데이터의 무결성을 보장하기 위한 제약사항
-- 1. PrimaryKey: 레코드(행)의 중복을 방지 (UNIQUE + NOT NULL)
-- 2. ForeignKey: 테이블 사이의 관계를 선언하는 역할
-- 3. UNIQUE: 중복 방지, NULL 허용
-- 4. NOT NULL: 필수 입력, 중복은 가능
-- 5. CHECK: 주어진 범주안의 값만 갖도록 함. 데이터를 점검하는 기능
-- 위 제약조건에 위배되는 값은 입력 안됨
-- default: 제약조건 생략 시, 기본값 부여됨

DROP TABLE `board`;
CREATE TABLE `board` (
  `no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` VARCHAR(100) DEFAULT NULL UNIQUE,
  `content` VARCHAR(4000) DEFAULT NULL,
  `id` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP NOT NULL
);

INSERT INTO BOARD (title, content, id, created_at)
VALUES ('TITLE1', 'CONTENT-1', 'admin', NOW()),
	('TITLE2', 'CONTENT-2', 'admin', NOW()),
    ('TITLE3', 'CONTENT-3', 'admin', NOW()),
    ('TITLE4', 'CONTENT-4', 'admin', NOW()),
    ('TITLE5', 'CONTENT-5', 'admin', NOW()),
    ('TITLE6', 'CONTENT-6', 'admin', NOW()),
    ('TITLE7', 'CONTENT-7', 'admin', NOW()),
    ('TITLE8', 'CONTENT-8', 'admin', NOW()),
    ('TITLE9', 'CONTENT-9', 'admin', NOW());
    
SELECT *
FROM board;

# 테이블에 적용된 인덱스 확인
-- key_name: PRIMARY는 클러스터형 인덱스, title은 UNIQUE 제약 조건으로 보조 인덱스가 자동 생성된 것을 확인할 수 있음
SHOW INDEX FROM board;

# 인덱스 생성
CREATE INDEX created_at_ix ON board(created_at);

# 인덱스 삭제
ALTER TABLE board DROP INDEX created_at_ix;

# 인덱스를 이용하는지 어떻게 확인할까?
-- EXPLAIN 키워드 혹은 Execution Plan 메뉴 활용
-- possible_keys: 사용 가능한 인덱스들의 목록
-- key: possible_keys 중에서 MySQL이 봤을 때 적합하다고 판단되어서 실제로 사용한 인덱스
-- Extra: 조회할 때 내부적으로 어떤 절차를 밟게 되는지, 신경 써야하는 부분이 어떤 것들이 있는지 알려줌
-- EXPLAIN에 대한 자세한 설명은 아래 사이트에서 확인
-- https://dev.mysql.com/doc/refman/8.0/en/explain-output.html
-- 또는 한글 번역 내용: https://nomadlee.com/mysql-explain-sql/
EXPLAIN
SELECT *
FROM board
WHERE no = 1;

EXPLAIN
SELECT *
FROM board
WHERE title LIKE 'TITLE1';

EXPLAIN
SELECT *
FROM board
WHERE title = 'TITLE1';

EXPLAIN
SELECT *
FROM board
WHERE created_at >= STR_TO_DATE('20220901', '%Y%m%d');

DROP TABLE `comment`;
CREATE TABLE `comment` (
  `no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `content` VARCHAR(4000) DEFAULT NULL,
  `id` VARCHAR(100) DEFAULT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `board_no` INT
);

# 처음 조회하면 board_no 컬럼에 조건이 없어서 인덱스가 없음을 확인
SHOW INDEX FROM `comment`;

# FOREIGN KEY 제약조건 추가 후 다시 SHOW INDEX를 실행하면 인덱스 추가된 것을 확인할 수 있음
ALTER TABLE `comment`
ADD CONSTRAINT comment_board_fk
FOREIGN KEY(`board_no`) REFERENCES `board`(`no`);

INSERT INTO `comment` (content, id, created_at, board_no)
VALUES ('COMMENT-CONTENT-1', 'admin', NOW(), 1);

EXPLAIN
SELECT *
FROM `comment`
WHERE board_no = 1;