	
create table board(
 boardNo number,
 pboardNo number,
 title varchar2(500),
 cont clob,
 delYn varchar2(1) default 'N',
 grOrd number,
 writer varchar2(20),
 writeDt date
);

alter table board add constraint board_pk primary key (boardNo);

comment on table board is '게시판';
comment on column board.boardNo is '게시물번호';
comment on column board.pboardNo is '상위 게시물번호';
comment on column board.title is '게시물 제목';
comment on column board.cont is '게시물 내용';
comment on column board.del_yn is '게시물 삭제 여부';
comment on column board.grOrd is '게시물 그룹내 순서';
comment on column board.writer is '게시물 작성자 아이디';
comment on column board.writeDt is '게시물 작성일시';



insert into board values (1, 0, '1번 글입니다.', '1번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board values (2, 0, '2번 글입니다.', '2번글 내용입니다.', 'N', 0, 'cony', sysdate);
insert into board values (3, 0, '3번 글입니다.', '3번글 내용입니다.', 'N', 0, 'sally', sysdate);
insert into board values (4, 0, '4번 글입니다.', '4번글 내용입니다.', 'N', 0, 'moon', sysdate);
insert into board values (5, 4, '5번 글은 4번글의 하위 글입니다.', '5번글 내용입니다.', 'N', 1, 'brown', sysdate); --lv1
insert into board values (6, 5, '6번 글은 5번글(4번글의 하위)의 하위 글입니다.', '6번글 내용입니다.', 'N', 1, 'sally', sysdate); --lv2
insert into board values (7, 5, '7번 글은 5번글의 하위 글입니다.', '7번글 내용입니다.', 'N', 2, 'brown', sysdate); --lv2
insert into board values (8, 0, '8번 글입니다.', '8번글 내용입니다.', 'N', 0, 'cony', sysdate);
insert into board values (9, 0, '9번 글입니다.', '9번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board values (10, 4, '10번 글은 4번의 하위 글입니다.', '10번글 내용입니다.', 'N', 2, 'sally', sysdate);
insert into board values (11, 0, '11번 글입니다.', '11번글 내용입니다.', 'N', 0, 'sally', sysdate);
insert into board values (12, 0, '12번 글입니다.', '12번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board values (13, 7, '13번은 7번글의 하위 글입니다.', '13번글 내용입니다.', 'N', 1, 'sally', sysdate);
insert into board values (14, 6, '14번은 6번글의 하위 글입니다.', '14번글 내용입니다.', 'N', 1, 'moon', sysdate);
1
2
3
4
  5
    6
    7
     13
  10
8
9
11
12


select lpad(' ', (level-1)*4 ) || title as title
 from board
start with pboardno=0
connect by prior boardno = pboardno
order siblings by grord, boardNo desc;