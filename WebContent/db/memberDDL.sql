--DROP
DROP SEQUENCE BMARK_SEQ;
DROP TABLE BOOKMARK;
DROP SEQUENCE QNA_SEQ;
DROP TABLE QNA;
DROP SEQUENCE NOTICE_SEQ;
DROP TABLE NOTICE;
DROP SEQUENCE SYB_SEQ;
DROP TABLE SYBOARD;
DROP SEQUENCE HREPLY_SEQ;
DROP TABLE HREPLY;
DROP SEQUENCE RHOS_SEQ;
DROP TABLE RHOSPITAL;
DROP SEQUENCE FREPLY_SEQ;
DROP TABLE FREPLY;
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE FILEBOARD;
DROP SEQUENCE SYMPTOM_SEQ;
DROP TABLE SCATEGORY;
DROP SEQUENCE RCATE_SEQ;

DROP TABLE RCATEGORY;
DROP TABLE ADMIN;
DROP TABLE MEMBER;

--멤버
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mBIRTH DATE NOT NULL,
    mGENDER VARCHAR2(10) NOT NULL, 
    mEMAIL VARCHAR2(50) UNIQUE,
    mPHONE VARCHAR2(50) NOT NULL,
    mADDRESS VARCHAR2(200),
    mADDRESS2 VARCHAR2(200), --?���?주소
    mGRADE NUMBER(1) DEFAULT 1 NOT NULL , --?���?
    mRDATE DATE DEFAULT SYSDATE NOT NULL
);
--관리자
DROP TABLE ADMIN ;
CREATE TABLE ADMIN(
    aID VARCHAR2(30) PRIMARY KEY,
    aPW VARCHAR2(30) NOT NULL,
    aNAME VARCHAR2(30)

);

--동물 카테고리
DROP SEQUENCE RCATE_SEQ;
CREATE SEQUENCE RCATE_SEQ MAXVALUE 999 NOCYCLE NOCACHE;
DROP TABLE RCATEGORY;
CREATE TABLE RCATEGORY(
    rCATEGORYID NUMBER(3) PRIMARY KEY,
    rCATEGORYNAME VARCHAR2(30) NOT NULL
);
--질병 카테고리
DROP SEQUENCE SYMPTOM_SEQ;
CREATE SEQUENCE SYMPTOM_SEQ MAXVALUE 99 NOCYCLE NOCACHE;
DROP TABLE SCATEGORY;
CREATE TABLE SCATEGORY(
    sCATEGORYID NUMBER(3) PRIMARY KEY,
    sCATEGORYNAME VARCHAR2(30) NOT NULL
);

--자유게시판(파일 첨부)
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
DROP TABLE FILEBOARD;
CREATE TABLE FILEBOARD(
    fNUM NUMBER(6) PRIMARY KEY,
    mID VARCHAR2(30) REFERENCES MEMBER(mID),
    fSUBJECT VARCHAR2(100) NOT NULL, --
    fCONTENT CLOB NOT NULL,--
    fFILENAME VARCHAR2(100), 
    fFILENAME2 VARCHAR2(100),
    fFILENAME3 VARCHAR2(100),--
    fRDATE DATE DEFAULT SYSDATE NOT NULL,
    fHIT NUMBER(6) DEFAULT 0 NOT NULL ,
    fGROUP NUMBER(6) NOT NULL,
    fSTEP NUMBER(6) NOT NULL,
    fINDENT NUMBER(6) NOT NULL,
    fIP VARCHAR2(30) NOT NULL --IP
     --
);

--자유게시판 댓글
DROP SEQUENCE FREPLY_SEQ;
CREATE SEQUENCE FREPLY_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
DROP TABLE FREPLY;
CREATE TABLE FREPLY(
    fRNUM NUMBER(6) PRIMARY KEY,
    fNUM NUMBER(6) REFERENCES FILEBOARD(fNUM),
    mID VARCHAR2(30) REFERENCES MEMBER(mID),
    aID VARCHAR2(30) REFERENCES ADMIN(aID),
    fRCONTENT CLOB NOT NULL,--
    fRRDATE DATE DEFAULT SYSDATE NOT NULL,
    fRIP VARCHAR2(30) NOT NULL --IP
     --
);

select * from FREPLY;

--병원 등록, 병원 보기

DROP SEQUENCE RHOS_SEQ;
CREATE SEQUENCE RHOS_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
DROP TABLE RHOSPITAL;
CREATE TABLE RHOSPITAL(
    rNUM NUMBER(6) PRIMARY KEY,
    mID VARCHAR2(30) REFERENCES MEMBER(mID),
    rCATEGORYID NUMBER(3) REFERENCES RCATEGORY(rCATEGORYID),
    rSUBJECT VARCHAR2(100) NOT NULL,
    rCONTENT CLOB NOT NULL,--
    rFILENAME VARCHAR2(100), 
    rFILENAME2 VARCHAR2(100),
    rFILENAME3 VARCHAR2(100),
    rHIT NUMBER(6) DEFAULT 0 NOT NULL,
    rRDATE DATE DEFAULT SYSDATE NOT NULL,
    rIP VARCHAR2(30) NOT NULL --IP
     --
);

--등록된 병원 댓글
DROP SEQUENCE HREPLY_SEQ;
CREATE SEQUENCE HREPLY_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
DROP TABLE HREPLY;
CREATE TABLE HREPLY(
    hNUM NUMBER(6) PRIMARY KEY,
    rNUM NUMBER(6) REFERENCES RHOSPITAL(rNUM),
    mID VARCHAR2(30) REFERENCES MEMBER(mID),
    aID VARCHAR2(50) REFERENCES ADMIN(aID),
    hCONTENT CLOB NOT NULL,--
    hRATING NUMBER(2,1),
    hRDATE DATE DEFAULT SYSDATE NOT NULL,
    hIP VARCHAR2(30) NOT NULL --IP
     --
);


--증상 검색 등록 게시판
DROP SEQUENCE SYB_SEQ;
CREATE SEQUENCE SYB_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
DROP TABLE SYBOARD;
CREATE TABLE SYBOARD(
    sNUM NUMBER(6)PRIMARY KEY, --
    aID VARCHAR2(50) REFERENCES ADMIN(aID),--
    sCATEGORYID NUMBER(3) REFERENCES SCATEGORY(sCATEGORYID),
    sSUBJECT VARCHAR2(100) NOT NULL, --
    sCONTENT CLOB NOT NULL --
    
);

--공지사항 게시판
DROP SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE NOTICE_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
DROP TABLE NOTICE;
CREATE TABLE NOTICE(
    nNUM NUMBER(6)PRIMARY KEY, --
    aID VARCHAR2(50) REFERENCES ADMIN(aID),--
    nSUBJECT VARCHAR2(100) NOT NULL, --
    nCONTENT CLOB, --
    nFILENAME VARCHAR2(100),
    nRDATE DATE DEFAULT SYSDATE NOT NULL,--
    nHIT NUMBER(6) DEFAULT 0 NOT NULL , --
    nIP VARCHAR2(30) NOT NULL --IP
     --
   
    
);
--QNA게시판
DROP SEQUENCE QNA_SEQ;
CREATE SEQUENCE QNA_SEQ MAXVALUE 999999 NOCYCLE NOCACHE;
DROP TABLE QNA;
CREATE TABLE QNA(
    qNUM NUMBER(6)PRIMARY KEY, --
    mID VARCHAR2(50) REFERENCES MEMBER(mID),--
    qSUBJECT VARCHAR2(100) NOT NULL, --
    qCONTENT CLOB, --
    qFILENAME VARCHAR2(100), --
    qRDATE DATE DEFAULT SYSDATE NOT NULL,
    qHIT NUMBER(6) DEFAULT 0 NOT NULL ,--
    qIP VARCHAR2(30) NOT NULL --IP
   
    
);

--북마크

DROP SEQUENCE BMARK_SEQ;
CREATE SEQUENCE BMARK_SEQ MAXVALUE 99 NOCYCLE NOCACHE;
DROP TABLE BOOKMARK;
CREATE TABLE BOOKMARK(
    bNUM NUMBER(2)PRIMARY KEY, --
    rNUM NUMBER(6) REFERENCES RHOSPITAL(rNUM),--
    mID VARCHAR2(30) REFERENCES MEMBER(mID)
  
   
    
);

