
create table board(
 boardNo number,
 pboardNo number,
 title varchar2(500),
 cont clob,
 delYn varchar2(1) default 'N',
 ord number,
 writer varchar2(20),
 writeDt date
);



insert into board values (1, '', '1번 글입니다.', '1번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board values (2, '', '2번 글입니다.', '2번글 내용입니다.', 'N', 0, 'cony', sysdate);
insert into board values (3, '', '3번 글입니다.', '3번글 내용입니다.', 'N', 0, 'sally', sysdate);
insert into board values (4, '', '4번 글입니다.', '4번글 내용입니다.', 'N', 0, 'moon', sysdate);
insert into board values (5, 4, '5번 글은 4번글의 하위 글입니다.', '5번글 내용입니다.', 'N', 1, 'brown', sysdate); --lv1
insert into board values (6, 5, '6번 글은 5번글(4번글의 하위)의 하위 글입니다.', '6번글 내용입니다.', 'N', 1, 'sally', sysdate); --lv2
insert into board values (7, 5, '7번 글은 5번글의 하위 글입니다.', '7번글 내용입니다.', 'N', 2, 'brown', sysdate); --lv2
insert into board values (8, '', '8번 글입니다.', '8번글 내용입니다.', 'N', 0, 'cony', sysdate);
insert into board values (9, '', '9번 글입니다.', '9번글 내용입니다.', 'N', 0, 'brown', sysdate);
insert into board values (10, 4, '10번 글은 4번의 하위 글입니다.', '10번글 내용입니다.', 'N', 2, 'sally', sysdate);
insert into board values (11, '', '11번 글입니다.', '11번글 내용입니다.', 'N', 0, 'sally', sysdate);
insert into board values (12, '', '12번 글입니다.', '12번글 내용입니다.', 'N', 0, 'brown', sysdate);
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