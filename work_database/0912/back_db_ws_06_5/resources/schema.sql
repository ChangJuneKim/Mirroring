use board_db;

#1
select
    date(now()) as '현재',
    date(date_add(now(), interval 1 day)) as '1일 후',
    date(date_add(now(), interval 1 week)) as '1주일 후',
    date(date_add(now(), interval 1 month)) as '1달 후';

#2
select id, title, created_at
from article
where datediff(now(), created_at) <= 1;

#3
select date_format('2022-07-06 13:50:20', '%Y-%m-%d %H:%i:%S');

#4
select board_id, count(id) as '게시글 수', sum(view_cnt) as '게시판 별 조회수'
from article
group by board_id;

#5
select user_seq, count(id)
from article
group by user_seq
order by user_seq;

select id, user_seq, article_id, content
from comment
where user_seq = 2;

#6
select user_seq, id
from article
where user_seq = 1;

select article_id, count(id) as '댓글의 개수'
from comment
group by article_id
having article_id = 1;

select board_id, sum(view_cnt)
from article
group by board_id;


#7 문제 결과화면이 잘못된듯
select board_id, round(avg(ifnull(view_cnt, 0)), 2) as '평균 조회수'
from article
group by board_id;

#8
select max(view_cnt) as '최대 조회수'
from article;

select id, view_cnt
from article
where view_cnt = 17;

select distinct user_seq
from comment
where article_id = 11;

select id,replace(user_name, substr(user_name, 2, 1), '*') as '이름', nickname
from user
where user_seq in (7, 10);

#9
select id, board_id
from article
where board_id = 1;

select count(id) as '게시판 1 총 파일개수'
from file
where article_id in (1, 5, 6, 7, 14, 15, 18, 20);


select id, board_id
from article
where board_id = 2;

select count(id) as '게시판 2 총 파일개수'
from file
where article_id in (2, 3, 8, 9, 10, 11, 17, 19);


select id, board_id
from article
where board_id = 3;

select count(id) as '게시판 3 총 파일개수'
from file
where article_id in (4, 12, 13, 16);

select id, name
from board
where id in (1, 2);

