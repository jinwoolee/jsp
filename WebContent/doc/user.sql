
table name : t_user

userId : varchar2(20),
userNm : varchar2(50),
pass : varchar2(30),
userAlias : varchar2(30),
reg_id : varchar2(20) default 'system',
reg_dt : date;

create table t_user(
userId  varchar2(20) ,
userNm  varchar2(50),
pass  varchar2(30),
userAlias  varchar2(30),
reg_id  varchar2(20) default 'system',
reg_dt  date);

select *
 from t_user;
 
 
comment on table t_user is '사용자';
comment on column t_user.userId is '사용자ID'; 
comment on column t_user.userNm is '사용자이름'; 
comment on column t_user.pass is '비밀번호'; 
comment on column t_user.userAlias is '사용자별칭'; 
comment on column t_user.reg_id is '등록자 아이디'; 
comment on column t_user.reg_dt is '등록일시'; 

desc t_user;

alter table t_user add CONSTRAINT PK_t_user PRIMARY KEY (userId);
 
insert into t_user values ('brown', '브라운', 'brownpass', 'br', 'system', sysdate);
insert into t_user values ('cony', '코니', 'conypass', 'co', 'system', sysdate);
insert into t_user values ('sally', '샐리', 'sallypass', 'sa', 'system', sysdate);

commit;

select *
 from t_user;
 