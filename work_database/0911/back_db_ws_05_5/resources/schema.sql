DROP DATABASE IF EXISTS board_db;

CREATE DATABASE board_db;

USE board_db;

DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `board_db`.`user` (
  `user_seq` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(16) NOT NULL,
  `user_pwd` VARCHAR(40) NOT NULL,
  `user_name` VARCHAR(40) NOT NULL,
  `nickname` VARCHAR(40) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `user_rank` INT NOT NULL DEFAULT 1,
  `joined_at` DATETIME NOT NULL DEFAULT NOW(),
  `modified_at` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`user_seq`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO user VALUES (1,'kimssafy','123','김창욱','김닉','kimssafy@email.com',1,now(),now()),
(2,'leessafy','123','이주영','이닉','leessafy@email.com',1,now(),now()),
(3,'parkssafy','123','박성주','박닉','parkssafy@email.com',1,now(),now()),
(4,'choissafy','123','최민준','최닉','choissafy@email.com',1,now(),now()),
(5,'jeongssafy','123','정진수','정닉','jeongssafy@email.com',1,now(),now()),
(6,'kangssafy','123','강홍석','강닉','kangssafy@email.com',1,now(),now()),
(7,'jossafy','123','조성준','조닉','jossafy@email.com',1,now(),now()),
(8,'yoonssafy','123','윤승아','윤닉','yoonssafy@email.com',1,now(),now()),
(9,'jangssafy','123','장영민','장닉','jangssafy@email.com',1,now(),now()),
(10,'limssafy','123','임석진','임닉','limssafy@email.com',1,now(),now());


DROP TABLE IF EXISTS `board`;

CREATE TABLE IF NOT EXISTS `board_db`.`board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(250) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT NOW(),
  `updated_at` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO board VALUES 
	(1,'게시판1','게시판1 입니다. ',now(),now()),
    (2,'게시판2','게시판2 입니다. ',now(),now()),
    (3,'게시판3','게시판3 입니다. ',now(),now());
    

DROP TABLE IF EXISTS `article`;

CREATE TABLE IF NOT EXISTS `board_db`.`article` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_seq` INT NOT NULL,
  `board_id` INT NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `content` VARCHAR(2000) NULL,
  `view_cnt` INT NULL DEFAULT 0,
  `lft` INT NOT NULL DEFAULT 0,
  `rgt` INT NOT NULL DEFAULT 0,
  `depth` INT NOT NULL DEFAULT 0,
  `created_at` DATETIME NOT NULL DEFAULT NOW(),
  `modified_at` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

 INSERT INTO article (id,user_seq,board_id,title,content,view_cnt,created_at) VALUES
 					 (1,1,1,'피부가 불러 황금시대','없는 청춘의 커다란 이것이다. 뭇 있는 날카로우나 구하지 찾아 때문이다. 바이며, 끝에 피가 하는 오아이스도 원대하고, 피부가 불러 황금시대의 뿐이다. ',5,now()- INTERVAL 2 DAY),
                     (2,10,2,'따뜻한 인간','지혜는 것이다.보라, 평화스러운 동력은 없으면, 위하여서. 같지 낙원을 얼마나 없으면 원질이 가치를 열락의 철환하였는가? 바로 온갖 할지니, 수 이상 무엇을 찾아다녀도, 그리하였는가? ',7,now()- INTERVAL 2 DAY),
                     (3,2,2,'도 얼마나 온갖','따뜻한 풀밭에 무엇을 주는 보는 청춘의 청춘 오직 불어 그리하였는가? 아니한 고행을 이것은 따뜻한 인간의 것은 사람은 있다. 기쁘며, 천고에 미묘한 보배를 쓸쓸한 꽃 얼음이 남는 보라. 이상이 내려온 동산에는 용감하고 끓는다. 웅대한 같이 더운지라 무엇을 얼',8,now()- INTERVAL 2 DAY),
                     (4,2,3,'이며, 속잎나고','없는 청춘의 커다란 이것이다. 뭇 있는 날카로우나 구하지 찾아 때문이다. 바이며, 끝에 피가 하는 오아이스도 원대하고, 피부가 불러 황금시대의 뿐이다. 지혜는 것이다.보라, 평화스러운 동력은 없으면, 위하여서. 같지 낙원을 얼마나 없으면 원질이 가치를 열락의',7,now()- INTERVAL 2 DAY),
                     (5,3,1,'몸이 끓는 트고, 것이',null,1,now()- INTERVAL 2 DAY),
                     (6,10,1,'보는 청춘의 청춘 오직','하게 속잎나고, 과실이 청춘은 용기가 그들에게 실로 뿐이다. 갑 위하여 앞이 맺어, 인생을 몸이 끓는 트고, 것이다. 유소년에게서 소담스러운 피가 힘있다. 사랑의 것은 목숨이 뿐이다. 심장은 그림자는 청춘이 인간이 있는가? 피가 충분히 천하를 예수는 오직 위하여서, 쓸쓸하랴? 꾸며 어디 굳세게 가는 눈에 놀이 위하여서. 가',8,now()- INTERVAL 2 DAY),
                     (7,10,1,'고, 시들어 아름다우','진 하였으며, 청춘은 찬미를 얼마나 뜨고, 시들어 아름다우냐? 청춘의 싶이 봄날의 어디 우리는 이상은 그들의 힘차게 있는 교향악이다. 대고, 영락과 그것은 같으며, 있으랴? 힘차게 관현악이며, 속잎나고, 하여도 것이다. 얼음과 예수는 이상은 칼이다.',15,now()- INTERVAL 2 DAY),
                     (8,7,2,'어나는 말이다. 꽃','이름과, 겨울이 내린 새겨지는 오면 까닭입니다. 비둘기, 다하지 못 이름자 시와 아침이 나의 봅니다. 소녀들의 시와 별을 이네들은 언덕 별빛이 걱정도 거외다. 보고, 다하지 잠, 청춘이 애기 가을 하나의 까닭입니다. 하나에 별을 어머니 어머니, 있습니다. 내 내 패, ',null,now()- INTERVAL 1 DAY),
                     (9,8,2,'웅대한 같이 더','가슴속에 있습니다. 별을 내일 내린 가난한 이 까닭입니다. 별에도 나는 이웃 별을 오면 아무 가난한 있습니다. 위에 가을로 시와 가슴속에 있습니다. 쉬이 멀듯이, 이름자를 불러 시인의 시와 북간도에 까닭입니다. 동경과 청춘이 헤는 멀리 묻힌 슬퍼하는 이런 봅니다.',5,now()- INTERVAL 1 DAY),
                     (10,2,2,'피어나는 말이','별을 흙으로 가슴속에 가을로 지나가는 있습니다. 언덕 못 묻힌 소학교 청춘이 위에도 덮어 계십니다. 쓸쓸함과 아이들의 시와 지나고 이웃 봄이 별을 말 걱정도 봅니다. 남은 다 지나가는 봅니다. 나의 계절이 잔디가 이름과, 별빛이 속의 밤을 릴케 헤일 봅니다. ',7,now()- INTERVAL 1 DAY),
                     (11,10,2,'래뿐일 부패뿐이','내린 언덕 이름과, 듯합니다. 지나고 하나에 다 이름자 멀리 시인의 멀듯이, 까닭입니다. 별 흙으로 이 지나고 거외다. 같이 어머님, 나의 계십니다. 않은 비둘기, 북간도에 마리아 이름을 쓸쓸함과 이 아침이 언덕 까닭입니다. 별 위에도 밤이 묻힌 써 다 남은 까닭이요, 나는 까닭입니다.',17,now()- INTERVAL 1 DAY),
                     (12,2,3,'청춘은 찬미를','별들을 내 된 소녀들의 이름자 봅니다. 속의 하나 봄이 아름다운 라이너 까닭입니다. 내 북간도에 같이 하나 버리었습니다. 내 지나고 밤을 까닭입니다. 쓸쓸함과 이름과, 나의 한 써 보고, 계십니다. 시와 우는 비둘기, 별 옥 가슴속에 하나 하나에 토끼, 듯합니다. 가을로 슬퍼하는 하나에 다 하나에 이런 까닭입니다.',8,now()- INTERVAL 1 DAY),
                     (13,1,3,' 관현악이며, 속잎나고, 하여도 것',null,11,now()- INTERVAL 1 DAY),
                     (14,9,1,'위하여, 눈이 그것은 듣는다','품었기 광야에서 끓는 같지 방지하는 지혜는 같으며, 인생의 뜨거운지라, 아름다우냐? 사랑의 인간은 지혜는 가슴에 있는 보라. 싸인 지혜는 싹이 착목한는 그들의 말이다. 풀이 같이, 위하여서, 싶이 뛰노는 운다. 타오르고 풀이 따뜻한 새 칼이다. 청춘은 우리 돋고, ',7,now()- INTERVAL 1 DAY),
                     (15,1,1,'청춘에서만 만물은 이것을 하였으며,','바이며, 인생을 듣기만 얼음이 때문이다. 그들에게 피고, 낙원을 있는 따뜻한 인간의 긴지라 무한한 얼마나 아니다. 구하지 사라지지 웅대한 남는 얼마나 것은 약동하다. 가슴에 황금시대의 그들의 이상은 칼이다. 역사를 하는 설레는 원질이 불어 그들의 것이다. 천자만홍이 대중을 반짝이는 심장의 약동하다.',null,now()- INTERVAL 1 DAY),
                     (16,2,3,'나고, 과실이 청','장식하는 노래하며 꽃이 보는 같으며, 튼튼하며, 이것이다. 끝에 우리 우리 길지 대한 희망의 있으랴? 동산에는 만천하의 스며들어 우리 소담스러운 예가 곳으로 밝은 철환하였는가? 방황하였으며, 무엇을 만천하의 실로 타오르고 되는 품으며, 것이다. 고행을 사랑의 설산에서 부패뿐이다.',1,now()),
                     (17,2,2,'가는 봅니다. 나의 계절이 잔디가','피에 대한 못할 할지니, 하였으며, 있으랴? 있는 거친 봄바람을 기쁘며, 것이다.보라, 자신과 심장은 보라. 긴지라 청춘의 청춘 사랑의 만천하의 자신과 피가 길지 청춘이 피다. 청춘의 위하여, 간에 커다란 가장 희망의 보라. 위하여, 인간의 뜨거운지라, 가치를 황금시대다.',15,now()),
                     (18,1,1,' 대고, 영락과 그것은 같으며, 있으랴? 힘차','이상은 동력은 소리다.이것은 인간의 이것을 품으며, 이것이다. 피가 능히 가는 피가 것이다. 우리 생생하며, 용기가 역사를 광야에서 이상은 웅대한 미인을 인생의 이것이다. 심장의 꽃이 위하여, 풍부하게 이상이 부패뿐이다. 무엇을 그들의 방지하는 가는 부패를 봄바람이다. ',6,now()),
                     (19,10,2,'덮어 쉬이 벌써 패, 까닭입니다.','',16,now()),
                     (20,1,1,' 별 흙으로 이 지나고 거외다.',' 몸이 때에, 고동을 귀는 앞이 아름다우냐? 피어나기 불어 때에, 놀이 동산에는 가치를 방황하였으며, 할지니, 보라. 구하지 무엇을 꽃이 끝에 심장의 사막이다. 힘차게 때까지 기쁘며, 이상의 싸인 같이 능히 것이다. 인생에 이상은 구하기 것이 튼튼하며, 그림자는 것은 이것이다.',10,now());





DROP TABLE IF EXISTS `comment`;

CREATE TABLE IF NOT EXISTS `board_db`.`comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_seq` INT NOT NULL,
  `article_id` INT NOT NULL,
  `content` VARCHAR(400) NULL,
  `lft` INT NOT NULL DEFAULT 0,
  `rgt` INT NOT NULL DEFAULT 0,
  `depth` INT NOT NULL DEFAULT 0,
  `created_at` DATETIME NOT NULL DEFAULT NOW(),
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO comment (id,user_seq,article_id,content) VALUES
	(1,10,1,'댓글 1'),(2,2,1,'댓글 2'),(3,1,1,'댓글 3'),(4,1,7,'댓글 4'),(5,2,2,'댓글 5'),(6,3,2,'댓글 6'),(7,7,11,'댓글 7'),(8,7,2,'댓글 8'),(9,3,3,'댓글 9'),(10,10,11,'댓글 10'),(11,2,3,'댓글 11'),(12,3,3,'댓글 12'),(13,2,3,'댓글 13'),(14,4,7,'댓글 14'),(15,6,1,'댓글 15'),(16,5,1,'댓글 16'),(17,9,2,'댓글 17'),(18,10,11,'댓글 18'),(19,5,3,'댓글 19'),(20,3,17,'댓글 20');


DROP TABLE IF EXISTS `file`;

CREATE TABLE IF NOT EXISTS `board_db`.`file` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `article_id` INT NOT NULL,
  `originfile` VARCHAR(300) NOT NULL,
  `savefolder` VARCHAR(45) NOT NULL,
  `savefile` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  )
ENGINE = InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO file VALUES (1,1,'file1_origin.txt','/files/article/220705/','550e8400-e29b-41d4-a716-446655440000'),
						(2,1,'file2_origin.txt','/files/article/220705/','8e73232a-fc34-11ec-b939-0242ac120002'),
                        (3,2,'file3_origin.txt','/files/article/220705/','8e7325dc-fc34-11ec-b939-0242ac120002'),
                        (4,2,'file4_origin.txt','/files/article/220705/','fce2c8ae-a9c4-4133-be16-f7a1a64ae115'),
                        (5,3,'file5_origin.txt','/files/article/220705/','c300a591-4fef-4f80-b230-ec89ce769d5c'),
                        (6,1,'file6_origin.txt','/files/article/220705/','41a36711-aca7-4598-aa30-3a1ecea6b1b4'),
                        (7,4,'file7_origin.txt','/files/article/220705/','95c221b1-5898-481d-8ed0-a7810ec1136b'),
                        (8,5,'file8_origin.txt','/files/article/220705/','6bf83892-2cfb-48d7-95a9-8af1c84a48c8'),
                        (9,10,'file9_origin.txt','/files/article/220705/','4101b359-3905-413c-8a4f-a53e20f7fe25'),
                        (10,12,'file10_origin.txt','/files/article/220705/','9eeed65d-5050-4d0f-8186-7e1506984bcc');
                        
                        

commit;

#1 board_db 데이터베이스를 사용하도록 설정하고, 테이블 구조를 확인하시오
use board_db;

show tables;

desc article;
desc board;
desc comment;
desc file;
desc user;

#2 각 테이블의 모든 레코드를 조회하고 각 몇개의 레코드가 있는지 확인하시오
select *
from article;
select count(*)
from article;

select *
from board;
select count(*)
from board;

select *
from comment;
select count(*)
from comment;

select *
from file;
select count(*)
from file;

select *
from user;
select count(*)
from user;

#3 article 테이블에서 board_id가 1인 게시글의 id, 제목, 내용을 조회하시오
select id, title, content
from article
where board_id = 1;

#4 article 테이블에서 게시글의 제목에 '청춘'이 포함된 게시글의 id, board_id, title, 작성일(created_at)를 조회하시오.
select id, board_id, title, created_at
from article
where title like '%청춘%';

#5 article 테이블에서 조회수가 10이상인 게시물의 id, title, content, view_cnt를 조회하고, view_cnt를 기준으로 내림차순으로 조회하시오
select id, title, content, view_cnt
from article
where view_cnt >= 10
order by view_cnt desc;

#6 article 테이블에서 조회수가 10미만인 게시물의 id, title, content, view_cnt를 조회하시오.
# 단, view_cnt가 null인 경우에 0으로 계산하여 조회하고, view_cnt 기준 오름차순으로 조회하시오. (14건)
select id, title, content, ifnull(view_cnt, 0) as 'view_cnt'
from article
where ifnull(view_cnt, 0) < 10
order by view_cnt;

#7 article 테이블에서 view_cnt가 15이상인 게시글을 조회한 다음, comment 테이블에서 해당 게시글들의 댓글의 id, article_id, content를
# 각각 조회하시오
select *
from article
where view_cnt >= 15;

select id, article_id, content
from comment
where article_id in (7, 11, 17, 19);


#8 article 테이블에서 모든 속성을 조회하시오, 단 view_cnt를 기준으로 내림차순으로 정렬하여 상위 5개 항목의 id, user_seq, board_id, title,
#  content, view_cnt를 조회하시오
select *
from article
order by view_cnt desc
limit 5;

#9 file 테이블에서 첨부파일이 존재하는 게시글의 id를 조회한 다음, article 테이블에서 해당 게시글의 id, title, content를 조회하시오.
# 단 content가 null일 경우 '내용 없음' 으로 조회
select distinct article_id
from file
where savefile is not null;

select id, title, ifnull(content, '내용 없음') as content
from article
where id in (1,2,3,4,5,10,12);

#10 user 테이블에서 user_seq와 id를 조회하시오. 단, id는 앞 네 글자만 보여주고 나머지는 '*'으로 숨겨 표시하고
# user_seq 기준으로 오름차순 정렬(10건)
select user_seq, rpad(substr(id, 1, 4), length(id), '*')
from user
order by user_seq;

#11 file 테이블에서 id와 파일 저장 경로를 조회하시오.
#단, 파일 저장 경로는 'savefolder/savefile_originfile' 이다.
select id, concat(savefolder,savefile,'_',originfile) as '저장 경로'
from file;
