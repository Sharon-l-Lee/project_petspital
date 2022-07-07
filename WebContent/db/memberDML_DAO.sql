SELECT * FROM MEMBER;
SELECT * FROM ADMIN;
SELECT * FROM NOTICE;
SELECT MID FROM MEMBER WHERE MEMAIL='bunny@naver.com';
SELECT MPW FROM MEMBER WHERE MEMAIL='bunny@naver.com';
DELETE FROM MEMBER WHERE MID = 'nnn';
commit;
--멤버 로그인
SELECT * FROM MEMBER WHERE mID ='aaa' AND mPW ='111';
--id 중복체크
SELECT * FROM MEMBER WHERE mID ='aaa';
--이메일 중복 체크
SELECT * FROM MEMBER WHERE mEMAIL ='bunny@naver.com';
--id로 dto가져오기
SELECT * FROM MEMBER WHERE mID ='aaa';

--관리자 로그인 
SELECT * FROM ADMIN WHERE aID ='admin1' AND aPW ='111';
--관리자 id로 dto가져오기
SELECT * FROM ADMIN WHERE aID ='admin1';
--회원 수
SELECT COUNT(*) CNT FROM MEMBER;
--회원 등급 변경
UPDATE MEMBER SET mGRADE='2'
                WHERE mID='aaa';
COMMIT;
--회원가입
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('aaa', '111', '이토끼', '95/01/01', 'M','bunny@naver.com', '010-0000-1111', '서울시 강남구', '어쩌구로'); 
    --정보수정
    UPDATE MEMBER SET mPW='111',
                mNAME='박짹짹',
                mEMAIL='bird085@naver.com',
                mBIRTH='95/12/25',
                mGENDER='M',
                mPHONE='010-0101-0101',
                mADDRESS='짹로 짹구',
                mADDRESS2='425-4'
                WHERE mID='ddd';

--등급별 회원 리스트 (아니면 등급 역순, 가입일 순)
SELECT * FROM MEMBER ORDER BY mGRADE DESC, mRDATE ;
SELECT * FROM
    (SELECT ROWNUM RN, M.* FROM 
        (SELECT MID, MNAME, MBIRTH, MEMAIL, MPHONE, MGRADE, MRDATE FROM MEMBER ORDER BY mRDATE DESC)M)
             WHERE RN BETWEEN 1 AND 10;
SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER)M;




SELECT * FROM (SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER ORDER BY mGRADE DESC, mRDATE)M)
    WHERE RN BETWEEN 1 AND 10;

--회원수
SELECT COUNT(*) FROM MEMBER;
--회원 탈퇴
DELETE FROM MEMBER WHERE MID = '7';
--탈퇴용 글삭제
DELETE FROM FILEBOARD WHERE MID ='7';
DELETE FROM BOOKMARK WHERE  MID ='aaa';
commit;


DELETE FROM HREPLY WHERE MID ='7';



DELETE FROM RHOSPITAL WHERE MID ='7';
DELETE FROM FREPLY WHERE MID ='7';

---공지사항 

--공지사항 게시판 리스트
SELECT * FROM (SELECT ROWNUM RN, B.* FROM (SELECT N.* FROM NOTICE N, ADMIN A WHERE N.AID = A.AID)B)
    WHERE RN BETWEEN 1 AND 30;
    
SELECT ROWNUM RN, B.* FROM (SELECT N.* FROM NOTICE N, ADMIN A WHERE N.AID = A.AID)B;
SELECT N.* FROM NOTICE N, ADMIN A WHERE N.AID = A.AID;
--공지사항 게시판 글쓰기
INSERT INTO NOTICE (nNUM, aID, aSUBJECT, aCONTENT, aFILENAME, aIP)
    VALUES(NOTICE_SEQ.NEXTVAL, 'zzz', '글1', '글1입니다', 'noImg.png', '127.10.26');

--공지사항 게시판 수정
UPDATE NOTICE SET nSUBJECT ='글1(수정)',
                nCONTENT='글1(수정)입니다',
                nFILENAME='noImg.png'
                WHERE nNUM ='1';
--공지사항 조회수 올리기
UPDATE NOTICE SET nHIT = nHIT+1
                WHERE nNUM='1';
                
--공지사항 글 지우기
DELETE FROM NOTICE WHERE nNUM='1';




--증상 검색
SELECT * FROM SYBOARD WHERE sCATEGORYID='1';

SELECT S.*, sCATEGORYNAME FROM SYBOARD S, SCATEGORY C WHERE S.sCATEGORYID = C.sCATEGORYID;
--증상 목록
SELECT sCATEGORYNAME FROM SCATEGORY;
--증상 글 등록(ADMIN)

SELECT sCATEGORYNAME FROM SCATEGORY WHERE sCATEGORYID='1';

INSERT INTO SYBOARD (sNUM, sCATEGORYID, aID, sSUBJECT, sCONTENT)
    VALUES (SYB_SEQ.NEXTVAL, 1,'admin1','눈꺼풀이 벌겋게 붓는다','눈꺼풀에 이상이 있다');
    
  --sNUM NUMBER(6)PRIMARY KEY, --
  --  sCATEGORYID NUMBER(3) REFERENCES SCATEGORY(sCATEGORYID),
  --  aID VARCHAR2(50) REFERENCES ADMIN(aID),--
 --   sSUBJECT VARCHAR2(100) NOT NULL, --
 --   sCONTENT VARCHAR2(4000) NOT NULL --

--증상 글 삭제(ADMIN)
DELETE FROM SYBOARD WHERE sNUM ='1';

--증상 글 수정 (ADMIN)
UPDATE SYBOARD SET sCATEGORYID = 2,
                sSUBJECT ='콧물을 많이 흘린다',
                sCONTENT='코에 문제가 있다'
                WHERE sNUM = '1';


--증상 글 snum으로 dto가져오기ㄴ
SELECT S.*, sCATEGORYNAME FROM SYBOARD S, SCATEGORY C WHERE S.sCATEGORYID = C.sCATEGORYID AND SNUM=1;
--게시판 리스트
SELECT * FROM
    (SELECT ROWNUM RN, A.*
    FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID ORDER BY fGROUP DESC, FSTEP)A)
    WHERE RN BETWEEN 1 AND 30 ;


--답변글전, 

UPDATE FILEBOARD SET fSTEP =fSTEP +1 WHERE fGROUP = 1 AND fSTEP > 0;
--답변글(로그인 한 사람만)
INSERT INTO FILEBOARD (fNUM, MID,  fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '-', 'noImg.png', NULL, NULL, 1, 1, 1, '127.10.26');
SELECT * FROM FILEBOARD;
--글쓰기 ( 로그인)

INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '-', 'noImg.png', NULL, NULL, FREPLY_SEQ.CURRVAL, 0, 0, '127.10.26');
--글 수정 (내 글만
UPDATE FILEBOARD SET fSUBJECT='글1(수정)',
                FCONTENT='수정된 글입니다',
                FIP='127.11.16',
                FFILENAME ='noImg.png',
                fFILENAME2 = NULL, 
                fFILENAME3 = NULL,
                fRDATE = SYSDATE
                WHERE fNUM='1';
--글 삭제(내 글만
DELETE FROM FILEBOARD WHERE mID='aaa';

--글 삭제(관리자)
COMMIT;

SELECT COUNT(*) FROM fileboard;
--FNUM로 DTO보기 (글 상세보기  + 조회수 높이기 용)
SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND fNUM='1';

--답변, 수정 상세보기 용 DTO보기
SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND fNUM='1';
--글 강제 삭제
DELETE FROM FILEBOARD F WHERE MID = 'AAA';
--조회수
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM='1';
COMMIT;
SELECT FNUM FROM FILEBOARD;
--자유게시판 댓글
--글에 댓글 수
SELECT COUNT(*)CNT FROM FREPLY WHERE FNUM='1';
--댓글 출력
SELECT FRNUM, FNUM, NVL2(MID,MID,AID),FRCONTENT,FRDATE, FRIP FROM FREPLY WHERE FNUM='16';
SELECT ROWNUM RN, F.* FROM (SELECT FRNUM, FNUM, NVL2(MID,MID,AID),FRCONTENT,FRDATE, FRIP FROM FREPLY WHERE FNUM='16')F;
   
SELECT FRNUM, FNUM, MID, nvl((select mname from member where mid=f.mid),'관리자') mname,FRCONTENT,FRRDATE, FRIP FROM FREPLY F where fnum=16 order by frnum desc;
SELECT * 
    FROM(SELECT ROWNUM RN, A.* 
        FROM (SELECT FRNUM, FNUM, MID, nvl((select mname from member where mid=f.mid),'관리자') mname,FRCONTENT,FRRDATE, FRIP FROM FREPLY F where fnum=16 order by frnum desc)A)
				WHERE rn between 1 and 10;
select f.*, mname from freply f, member m where f.mid=m.mid;
select * from freply;
--댓글 입력
INSERT INTO FREPLY(fRNUM, fNUM, mID, aId, fRCONTENT, FRRDATE, FRIP ) VALUES(FREPLY_SEQ.NEXTVAL, 16, 'aaa',null, '댓글 확인',SYSDATE, '127.10.25' );
--댓글 수정
UPDATE FREPLY SET fRCONTENT= '댓글확인수정' WHERE fRNUM=1;
--댓글 삭제
DELETE FROM FREPLY WHERE fRNUM='2'; 
--댓글 dto
SELECT FRNUM, FNUM, M.MID, MNAME, FRCONTENT, FRRDATE, FRIP FROM FREPLY F, MEMBER M WHERE F.MID=M.MID AND FNUM=16;
--회원 리스트(관리자)
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT mPHOTO, mID, mNAME FROM MVC_MEMBER ORDER BY mRDATE DESC)A)
    WHERE RN BETWEEN 1 AND 11;
--글 삭제(관리자)
DELETE FROM FILEBOARD WHERE FNUM='2';


select * from freply where fnum=16;

--병원 글 입력 (grade2인 사람만)
INSERT INTO RHOSPITAL ( rNUM,rCATEGORYID, mID, rSUBJECT, rCONTENT,rFILENAME, rFILENAME2, rFILENAME3, rRDATE,rIP  )
    VALUES(RHOS_SEQ.NEXTVAL, 1, 'aaa','강남 동물병원', '강남에 있는 동물병원입니다', 'noImg.png', NULL, NULL, SYSDATE, '123.10.52');
--병원 글 출력
SELECT * FROM
    (SELECT ROWNUM RN, A.*
    FROM(SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.mID=M.mID ORDER BY RNUM DESC)A)
    WHERE RN BETWEEN 1 AND 30 ;
--동물별 병원글 출력
SELECT ROWNUM RN, A.*
    FROM(SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.mID=M.mID and RCATEGORYID= 1)A;
SELECT * FROM RCATEGORY;
SELECT * FROM
    (SELECT ROWNUM RN, A.*
        FROM(SELECT R.*, RCATEGORYNAME, MNAME FROM RHOSPITAL R, MEMBER M, RCATEGORY C 
           WHERE R.mID=M.mID AND C.RCATEGORYID=r.RCATEGORYID and RCATEGORYNAME LIKE '%'||''||'%' ORDER BY RNUM DESC)A)
                WHERE RN BETWEEN 1 AND 30;
                
SELECT R.*, RCATEGORYNAME, MNAME FROM RHOSPITAL R, MEMBER M, RCATEGORY C 
    WHERE R.mID=M.mID AND C.RCATEGORYID=r.RCATEGORYID and RCATEGORYNAME LIKE '%'||'강아지'||'%' ORDER BY RNUM DESC;
        
SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.mID=M.mID and rcategoryid=1;
--병원 글 삭제 (글 쓴 사람만)
DELETE FROM RHOSPITAL WHERE rNUM=1;
--병원 글 수정 (글 쓴 사람만)
UPDATE RHOSPITAL SET rCATEGORYID=2,
                    rSUBJECT='분당 동물병원',
                    rCONTENT='분당에 있는 동물병원입니다',
                    rFILENAME='noImg.png',
                    rFILENAME2=NULL,
                    rFILENAME3=NULL
                    WHERE rNUM=1;
--조회수 올리기
UPDATE RHOSPITAL SET rHIT = rHIT+1 WHERE rNUM=1;
--글 갯수
SELECT COUNT(*) FROM RHOSPITAL;

--병원 글 상세보기(조회수 up)
SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.MID = M.MID AND rNUM=2;
--수정용 상세보기
SELECT R.*, MNAME FROM RHOSPITAL R, MEMBER M WHERE R.MID = M.MID AND rNUM=2;
--강제 삭제
DELETE FROM RHOSPITAL WHERE MID =?;

select * from RHOSPITAL;
select * from HREPLY;
--병원 글 댓글
INSERT INTO HREPLY(hNUM, rNUM, mID, aId, hCONTENT , hRDATE , hIP ) VALUES(HREPLY_SEQ.NEXTVAL, 2, 'bbb',null, '댓글 확인',SYSDATE, '127.10.25' );
--병원 글 댓글 출력
SELECT * 
    FROM(SELECT ROWNUM RN, A.* 
        FROM (SELECT hNUM, rNUM, MID, nvl((select mname from member where mid=h.mid),'관리자') mname,hCONTENT,hRDATE, hIP FROM HREPLY H where rNUM=4 order by hNUM desc)A)
				WHERE rn between 1 and 10;
--댓글 갯수
SELECT COUNT(*) FROM HREPLY;

--글에 댓글 수
SELECT COUNT(*)CNT FROM HREPLY WHERE rNUM='2';

--병원 댓글 수정
UPDATE HREPLY SET hCONTENT= '댓글확인수정' WHERE hNUM=1;
--댓글 삭제
DELETE FROM HREPLY WHERE hNUM='2'; 

--병원 댓글 dto
SELECT hNUM, rNUM, MID, nvl((select mname from member where mid=h.mid),'관리자') mname,hCONTENT,hRDATE, hIP FROM HREPLY H where rNUM=2;

--증상 카테고리 출력
select scategoryid from SCATEGORY;
select SCATEGORYNAME FROM SCATEGORY WHERE SCATEGORYID = 1;


--동물
select rcategoryname from RCATEGORY;
select rCATEGORYNAME FROM RCATEGORY WHERE RCATEGORYID = 1;
SELECT * FROM HREPLY;
--북마크
--북마크 리스트
select * FROM RHOSPITAL;
SELECT *
    FROM (SELECT ROWNUM RN, A.*
        FROM(SELECT R.* ,BNUM FROM BOOKMARK B , RHOSPITAL R WHERE B.MID='ddd' ORDER BY B.RNUM DESC)A)
        WHERE RN BETWEEN 1 AND 10;
        SELECT R.* FROM BOOKMARK B , RHOSPITAL R WHERE r.rnum=b.rnum AND B.MID='ddd' ORDER BY B.RNUM DESC;
 --       SELECT H.*, BNUM, H.RNUM, B.MID FROM BOOKMARK B , HREPLY H WHERE H.MID = B.MID AND B.MID='ddd' ORDER BY H.RNUM DESC;
SELECT ROWNUM RN, B.*
    FROM(SELECT * FROM BOOKMARK WHERE MID='ddd' ORDER BY RNUM DESC)B;
SELECT * FROM BOOKMARK WHERE MID='ddd' ORDER BY RNUM DESC;
--북마크 넣기

INSERT INTO BOOKMARK (bNUM, rNUM, mID, aID) VALUES (BMARK_SEQ.NEXTVAL, 4, 'ddd', null);
INSERT INTO BOOKMARK (bNUM, rNUM, mID) VALUES (BMARK_SEQ.NEXTVAL, 4, 'ddd');
select * from
    (select rownum rn, a.* from (select b.rnum, rsubject, rrdate from bookmark b, RHOSPITAL r where b.rnum = r.rnum and b.mid = 'ddd' order by r.rnum desc)a)
    where rn between 1 and 10;
    
select rownum rn, a.* from (select b.*, rsubject, rrdate from bookmark b, RHOSPITAL r where b.rnum = r.rnum and b.mid = 'ddd' order by r.rnum desc)a;
select b.*, rsubject, rrdate from bookmark b, RHOSPITAL r where b.rnum = r.rnum and b.mid = 'ddd' order by r.rnum desc;

--북마크 지우기
DELETE BOOKMARK WHERE rNUM= 2 AND mID = 'ddd';
SELECT COUNT(*) FROM BOOKMARK b WHERE rNUM=4 AND b.mID='ddd';
--북마크 보기
SELECT * FROM BOOKMARK b WHERE b.mID='ddd';
SELECT COUNT(*) FROM BOOKMARK WHERE mID='ddd';
--북마크 갯수
SELECT COUNT(*) FROM BOOKMARK WHERE rNUM=4 AND mID='aaa';
commit;
--자유게시판 검색

SELECT * 
    FROM(SELECT ROWNUM RN, A.* 
        FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID AND fSUBJECT LIKE '%'||'고양이'||'%' ORDER BY fGROUP DESC, FSTEP)A)
				WHERE RN BETWEEN 1 AND 10;
SELECT * FROM FILEBOARD WHERE fSUBJECT LIKE '%'||'강아지'||'%';
SELECT COUNT(*)CNT FROM FILEBOARD WHERE fSUBJECT LIKE '%'||'강아지'||'%';


--QNA작성
--질문의 경우
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'bbb', '질문있습니다', '강아지가 갑자기 이상 행동을 합니다', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
--답변의 경우

--답변글 전
UPDATE QNA SET qSTEP =qSTEP +1 WHERE qGROUP = 1 AND qSTEP > 0;
--답변글(로그인 한 사람만)

INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'bbb', '답변합니다', '온라인 상으로 자세한 증상이 없으면 진단하기 어렵습니다', NULL, SYSDATE, 1,1,1,'125.10.15'
    );
    
 --글 수정 (내 글만
UPDATE QNA SET qSUBJECT='글1(수정)',
                qCONTENT='수정된 글입니다',
                qIP='127.11.16',
                qFILENAME ='noImg.png',
                qRDATE = SYSDATE
                WHERE qNUM='1';
--글 삭제(내 글만
DELETE FROM QNA WHERE mID='aaa';
--글 삭제 전 답변도 삭제
DELETE FROM QNA WHERE qGROUP=1;
DELETE FROM QNA WHERE QNUM =1 AND QGROUP = 1;
--글 삭제(관리자)
COMMIT;
SELECT * FROM QNA;
SELECT COUNT(*) FROM QNA;
--FNUM로 DTO보기 (글 상세보기  + 조회수 높이기 용)
SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.MID = Q.MID AND qNUM='1';

--답변, 수정 상세보기 용 DTO보기
SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.MID = Q.MID AND qNUM='1';
--글 강제 삭제
DELETE FROM QNA Q WHERE MID = 'AAA';
--조회수
UPDATE QNA SET qHIT = qHIT+1 WHERE qNUM='1';   
SELECT COUNT(*) FROM QNA WHERE qGROUP = 5;
--QNA출력
SELECT * FROM
    (SELECT ROWNUM RN, A.*
    FROM(SELECT Q.*, MNAME FROM QNA Q, MEMBER M WHERE Q.mID=M.mID and qGroup = 1 and qstep >0 ORDER by qSTEP)A)
    WHERE RN BETWEEN 1 AND 30; 