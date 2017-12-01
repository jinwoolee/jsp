  CREATE TABLE T_USER 
   (	USERID VARCHAR2(20 BYTE), 
	USERNM VARCHAR2(50 BYTE), 
    USERALIAS VARCHAR2(50 BYTE), 
	PASS VARCHAR2(30 BYTE), 
    PICTURE_PATH VARCHAR2(50),
    REG_ID VARCHAR2(20 BYTE), 
	REG_DT DATE );
comment table on t_user is '사용자 테이블';
comment column on t_user.userId is '사용자 아이디';
comment column on t_user.userNm is '사용자 이름';
comment column on t_user.userAlias is '사용자 별칭';
comment column on t_user.pass is '비밀번호';
comment column on t_user.picture_path is '사용자 사진 경로';
comment column on t_user.reg_id is '등록자 아이디';
comment column on t_user.reg_dt is '등록 일시';