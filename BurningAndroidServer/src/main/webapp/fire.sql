--���� ok
CREATE TABLE FIRE_USER (
	ID VARCHAR2(20) NOT NULL,
	PW VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	TEL	VARCHAR2(20) NOT NULL,
	ADDR VARCHAR2(200),
	B_NAME VARCHAR2(100),
	GEN	VARCHAR2(10),
	BIR	VARCHAR2(20),
	CODE NUMBER(3) NOT NULL
);
ALTER TABLE FIRE_USER ADD CONSTRAINT PK_FIRE_USER PRIMARY KEY (ID);

--�ǹ� ����
CREATE TABLE BLD_MNG (
	BLD_FLR VARCHAR2(10) NOT NULL,
	BLD_DWG VARCHAR2(50)
);
ALTER TABLE BLD_MNG ADD CONSTRAINT PK_BLD_MNG PRIMARY KEY (BLD_FLR);

--�ҹ� ���� ���� ok
CREATE TABLE FRF_INF (
	FRF_NUM	NUMBER(20) NOT NULL,
	FRF_TLT	VARCHAR2(20) NOT NULL,
	FRF_CNT	VARCHAR2(20) NOT NULL,
	FRF_FILE VARCHAR2(100),
	FRF_DT DATE NOT NULL
);
ALTER TABLE FRF_INF ADD CONSTRAINT PK_FRF_INF PRIMARY KEY (FRF_NUM);

CREATE sequence FRF_NUM2
start with 1
increment by 1;

--��ȭ�� ���� 
CREATE TABLE FRXT_INFO (
	F_NICK VARCHAR2(20) constraint FRXT_INFO_uk unique,
	NFC_NUM	VARCHAR2(20) NOT NULL,
	NFC_PRO	DATE NOT NULL,
	USE_DT DATE NOT NULL,
	NFC_REGI DATE NOT NULL,
	BLD_FLR VARCHAR2(10) NOT NULL
);

ALTER TABLE FRXT_INFO ADD CONSTRAINT PK_FRXT_INFO PRIMARY KEY (NFC_NUM);
ALTER TABLE FRXT_INFO ADD CONSTRAINT FK_BLD_MNG_TO_FRXT_INFO_1 FOREIGN KEY (BLD_FLR) REFERENCES BLD_MNG (BLD_FLR);

insert into FRXT_INFO values('3�� ���ǽ�B','M68210806', '2021-01-27', '2031-01-27', '2021-03-18', '3'); 
insert into FRXT_INFO values('3�� ���ǽ�A','M68210807', '2021-01-24', '2031-01-24', '2021-03-18', '3'); 
insert into FRXT_INFO values('3�� ���ǽ�C','M78210807', '2021-01-28', '2031-01-28', '2021-03-18', '3'); 
insert into FRXT_INFO values('2�� �繫��','M78210815', '2021-01-13', '2031-01-13', '2021-03-18', '2'); 
insert into FRXT_INFO values('2�� ȸ�ǽ�','M78210822', '2021-01-30', '2031-01-30', '2021-03-18', '2'); 

-- ��ȭ�� üũ
CREATE TABLE FRXT_CHCK (
	CHCK_NUM NUMBER(6) NOT NULL,
	F_NICK VARCHAR2(20)	NOT NULL,
	NFC_NUM	VARCHAR2(20) NOT NULL,
	BLD_FLR VARCHAR2(10) NOT NULL,
	CHCK_PWD VARCHAR2(20) NOT NULL,
	CHCK_PRESS VARCHAR2(20)	NOT NULL,
	CHCK_PIN VARCHAR2(20) NOT NULL,
	CHCK_BODY VARCHAR2(20) NOT NULL,
	CHCK_LEVER VARCHAR2(20)	NOT NULL,
	CHCK_HOSE VARCHAR2(20) NOT NULL,
	CHCK_DATE DATE
);
ALTER TABLE FRXT_CHCK ADD CONSTRAINT PK_FRXT_CHCK PRIMARY KEY (CHCK_NUM);
ALTER TABLE FRXT_CHCK ADD CONSTRAINT FK_FRXT_INFO_TO_FRXT_CHCK_1 FOREIGN KEY (F_NICK) REFERENCES FRXT_INFO (F_NICK);
ALTER TABLE FRXT_CHCK ADD CONSTRAINT FK_FRXT_INFO_TO_FRXT_CHCK_2 FOREIGN KEY (NFC_NUM) REFERENCES FRXT_INFO (NFC_NUM);
ALTER TABLE FRXT_CHCK ADD CONSTRAINT FK_BLD_MNG_TO_FRXT_CHCK_1 FOREIGN KEY (BLD_FLR) REFERENCES BLD_MNG (BLD_FLR);

CREATE sequence CHCK_NUM2
start with 1
increment by 1;

insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�B','M68210806','3','����','����','����','����','����','����','2021-04-18'); 
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�B','M68210806','3','����','����','����','����','����','����','2021-05-18'); 
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�B','M68210806','3','����','����','����','����','����','����','2021-06-18'); 
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�B','M68210806','3','����','����','����','����','����','����','2021-07-18');

insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�A','M68210807','3','����','����','����','����','����','����','2021-04-15');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�A','M68210807','3','����','����','����','����','����','����','2021-05-15');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�A','M68210807','3','����','����','����','����','����','����','2021-06-15');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�A','M68210807','3','����','����','����','����','����','����','2021-07-15');

insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�C','M78210807','3','����','����','����','����','����','����','2021-04-18');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�C','M78210807','3','����','����','����','����','����','����','2021-05-18');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�C','M78210807','3','����','����','����','����','����','����','2021-06-17');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'3�� ���ǽ�C','M78210807','3','����','����','����','����','����','����','2021-07-16');

insert into FRXT_CHCK values(CHCK_NUM2.nextval,'2�� �繫��','M78210815','2','����','����','����','����','����','����','2021-04-18');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'2�� �繫��','M78210815','2','����','����','����','����','����','����','2021-05-18');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'2�� �繫��','M78210815','2','����','����','����','����','����','����','2021-06-17');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'2�� �繫��','M78210815','2','����','����','����','����','����','����','2021-07-16');
insert into FRXT_CHCK values(CHCK_NUM2.nextval,'2�� �繫��','M78210815','2','����','����','������','����','����','����','2021-08-10');

--��ȭ�� �˸� 
CREATE TABLE FRXT_ALR (
	ALR_NUM	NUMBER(6) NOT NULL,
	NFC_NUM	VARCHAR2(20) NOT NULL,
	ID VARCHAR2(20)	NOT NULL,
	ALR_DATE DATE NOT NULL,
	BLD_FLR VARCHAR2(10) NOT NULL
);
ALTER TABLE FRXT_ALR ADD CONSTRAINT PK_FRXT_ALR PRIMARY KEY (ALR_NUM);
ALTER TABLE FRXT_ALR ADD CONSTRAINT FK_FIRE_USER_TO_FRXT_ALR_1 FOREIGN KEY (ID) REFERENCES FIRE_USER (ID);
ALTER TABLE FRXT_ALR ADD CONSTRAINT FK_FRXT_INFO_TO_FRXT_ALR_1 FOREIGN KEY (NFC_NUM) REFERENCES FRXT_INFO (NFC_NUM);
ALTER TABLE FRXT_ALR ADD CONSTRAINT FK_BLD_MNG_TO_FRXT_ALR_1 FOREIGN KEY (BLD_FLR) REFERENCES BLD_MNG (BLD_FLR);

CREATE sequence ALR_NUM2
start with 1
increment by 1;

-- ��ȭ�� ����
CREATE TABLE FRXT_CLC (
	CLC_NO VARCHAR2(20)	NOT NULL,
	ID VARCHAR2(20) NOT NULL,
	NFC_NUM	VARCHAR2(20) NOT NULL,
	CLC_DT DATE	NOT NULL,
	CLC_DSP VARCHAR2(50) NOT NULL
);
ALTER TABLE FRXT_CLC ADD CONSTRAINT PK_FRXT_CLC PRIMARY KEY (CLC_NO);
ALTER TABLE FRXT_CLC ADD CONSTRAINT FK_FIRE_USER_TO_FRXT_CLC_1 FOREIGN KEY (ID) REFERENCES FIRE_USER (ID);
ALTER TABLE FRXT_CLC ADD CONSTRAINT FK_FRXT_INFO_TO_FRXT_CLC_1 FOREIGN KEY (NFC_NUM) REFERENCES FRXT_INFO (NFC_NUM);


-- ��ȭ�� ��������
CREATE TABLE FRXT_AGN (
	AGN_NUM	NUMBER(20)	NOT NULL,
	NFC_NUM	VARCHAR2(20) NOT NULL,
	AGN_VALUE NUMBER(20)	NOT NULL
);
ALTER TABLE FRXT_AGN ADD CONSTRAINT PK_FRXT_AGN PRIMARY KEY (AGN_NUM);
ALTER TABLE FRXT_AGN ADD CONSTRAINT FK_FRXT_INFO_TO_FRXT_AGN_1 FOREIGN KEY (NFC_NUM) REFERENCES FRXT_INFO (NFC_NUM);

CREATE sequence AGN_NUM2
start with 1
increment by 1;

-- �з°� ����
CREATE TABLE FRXT_PRE (
	PRE_NUM	NUMBER NOT NULL,
	NFC_NUM	VARCHAR2(20) NOT NULL,
	PRE_VALUE NUMBER NOT NULL,
	PRE_DT DATE
);
ALTER TABLE FRXT_PRE ADD CONSTRAINT PK_FRXT_PRE PRIMARY KEY (PRE_NUM);
ALTER TABLE FRXT_PRE ADD CONSTRAINT FK_FRXT_INFO_TO_FRXT_PRE_1 FOREIGN KEY (NFC_NUM) REFERENCES FRXT_INFO (NFC_NUM);

CREATE sequence PRE_NUM2
start with 1
increment by 1;
---------------------------------------------------------------------------------------------------------------------
-- ���̺� Ȯ��
select * from FIRE_USER;
select * from BLD_MNG;
select * from FRF_INF;
select * from FRXT_INFO;
select * from FRXT_ALR;
select * from FRXT_CLC;
select * from FRXT_CHCK;
select * from FRXT_AGN;
select * from FRXT_PRE;

-- ���̺� ����
drop table FIRE_USER;
drop table BLD_MNG;
drop table FRF_INF;
drop table FRXT_INFO;
drop table FRXT_ALR;
drop table FRXT_CLC;
drop table FRXT_CHCK;
drop table FRXT_AGN;
drop table FRXT_PRE;

-- ������ ����
drop sequence ALR_NUM2;
drop sequence CHCK_NUM2;
drop sequence AGN_NUM2;
drop sequence PRE_NUM2;
drop sequence FRF_NUM2;

