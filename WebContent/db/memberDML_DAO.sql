SELECT * FROM MEMBER;
commit;
--��� �α���
SELECT * FROM MEMBER WHERE mID ='aaa' AND mPW ='111';
--id �ߺ�üũ
SELECT * FROM MEMBER WHERE mID ='aaa';
--�̸��� �ߺ� üũ
SELECT * FROM MEMBER WHERE mEMAIL ='bunny@naver.com';
--id�� dto��������
SELECT * FROM MEMBER WHERE mID ='aaa';

--������ �α��� 
SELECT * FROM ADMIN WHERE aID ='admin1' AND aPW ='111';
--������ id�� dto��������
SELECT * FROM ADMIN WHERE aID ='admin1';
--ȸ�� ��
SELECT COUNT(*) CNT FROM MEMBER;
--ȸ�� ��� ����
UPDATE MEMBER SET mGRADE='2'
                WHERE mID='aaa';

--ȸ������
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('aaa', '111', '���䳢', '95/01/01', 'M','bunny@naver.com', '010-0000-1111', '����� ������', '��¼����'); 
    --��������
    UPDATE MEMBER SET mPW='111',
                mNAME='��±±',
                mEMAIL='bird085@naver.com',
                mBIRTH='95/12/25',
                mGENDER='M',
                mPHONE='010-0101-0101',
                mADDRESS='±�� ±��',
                mADDRESS2='425-4'
                WHERE mID='ddd';

--��޺� ȸ�� ����Ʈ (�ƴϸ� ��� ����, ������ ��)
SELECT * FROM MEMBER ORDER BY mGRADE DESC, mRDATE ;
SELECT * FROM (SELECT ROWNUM RN, M.* FROM (SELECT MID, MNAME, MBIRTH, MEMAIL, MPHONE, MGRADE, MRDATE FROM MEMBER)M)
    WHERE RN BETWEEN 1 AND 10
    ORDER BY mGRADE DESC, mRDATE;
SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER)M;



SELECT * FROM (SELECT ROWNUM RN, M.* FROM (SELECT * FROM MEMBER ORDER BY mGRADE DESC, mRDATE)M)
    WHERE RN BETWEEN 1 AND 10;

--ȸ�� Ż��
DELETE FROM MEMBER WHERE MID = '7';
--Ż��� �ۻ���


---�������� 

--�������� �Խ��� ����Ʈ
SELECT * FROM (SELECT ROWNUM RN, B.* FROM (SELECT N.* FROM NOTICE N, ADMIN A WHERE N.AID = A.AID)B)
    WHERE RN BETWEEN 1 AND 30;
    
SELECT ROWNUM RN, B.* FROM (SELECT N.* FROM NOTICE N, ADMIN A WHERE N.AID = A.AID)B;
SELECT N.* FROM NOTICE N, ADMIN A WHERE N.AID = A.AID;
--�������� �Խ��� �۾���
INSERT INTO NOTICE (nNUM, aID, aSUBJECT, aCONTENT, aFILENAME, aIP)
    VALUES(NOTICE_SEQ.NEXTVAL, 'zzz', '��1', '��1�Դϴ�', 'noImg.png', '127.10.26');

--�������� �Խ��� ����
UPDATE NOTICE SET nSUBJECT ='��1(����)',
                nCONTENT='��1(����)�Դϴ�',
                nFILENAME='noImg.png'
                WHERE nNUM ='1';
--�������� ��ȸ�� �ø���
UPDATE NOTICE SET nHIT = nHIT+1
                WHERE nNUM='1';
                
--�������� �� �����
DELETE FROM NOTICE WHERE nNUM='1';




--���� �˻�
SELECT * FROM SYBOARD WHERE sCATEGORYID='1';

SELECT * FROM SYBOARD;
--���� ���
SELECT sCATEGORYNAME FROM SCATEGORY;
--���� �� ���(ADMIN)

SELECT sCATEGORYNAME FROM SCATEGORY WHERE sCATEGORYID='1';

INSERT INTO SYBOARD (sNUM, sCATEGORYID,  sSUBJECT, sCONTENT)
    VALUES (SYB_SEQ.NEXTVAL, 1,'����Ǯ�� ���Ӱ� �״´�','����Ǯ�� �̻��� �ִ�');
    
  --sNUM NUMBER(6)PRIMARY KEY, --
  --  sCATEGORYID NUMBER(3) REFERENCES SCATEGORY(sCATEGORYID),
  --  aID VARCHAR2(50) REFERENCES ADMIN(aID),--
 --   sSUBJECT VARCHAR2(100) NOT NULL, --
 --   sCONTENT VARCHAR2(4000) NOT NULL --

--���� �� ����(ADMIN)
DELETE FROM SYBOARD  WHERE sNUM ='1';

--���� �� ���� (ADMIN)
UPDATE SYBOARD SET sCATEGORYID = 2,
                sSUBJECT ='�๰�� ���� �기��',
                sCONTENT='�ڿ� ������ �ִ�'
                WHERE sNUM = '1';

--�Խ��� ����Ʈ
SELECT * FROM
    (SELECT ROWNUM RN, A.*
    FROM(SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.mID=M.mID ORDER BY fGROUP DESC, FSTEP)A)
    WHERE RN BETWEEN 1 AND 30 ;


--�亯����, 

UPDATE FILEBOARD SET fSTEP =fSTEP +1 WHERE fGROUP = 1 AND fSTEP > 0;
--�亯��(�α��� �� �����)
INSERT INTO FILEBOARD (fNUM, MID,  fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '��1', '-', 'noImg.png', NULL, NULL, 1, 1, 1, '127.10.26');
SELECT * FROM FILEBOARD;
--�۾��� ( �α���)

INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '��1', '-', 'noImg.png', NULL, NULL, FREPLY_SEQ.CURRVAL, 0, 0, '127.10.26');
--�� ���� (�� �۸�
UPDATE FILEBOARD SET fSUBJECT='��1(����)',
                FCONTENT='������ ���Դϴ�',
                FIP='127.11.16',
                FFILENAME ='noImg.png',
                fFILENAME2 = NULL, 
                fFILENAME3 = NULL,
                fRDATE = SYSDATE
                WHERE fNUM='1';
--�� ����(�� �۸�
DELETE FROM FILEBOARD WHERE mID='aaa';

--�� ����(������)
COMMIT;

SELECT COUNT(*) FROM fileboard;
--FNUM�� DTO���� (�� �󼼺���  + ��ȸ�� ���̱� ��)
SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND fNUM='1';

--�亯, ���� �󼼺��� �� DTO����
SELECT F.*, MNAME FROM FILEBOARD F, MEMBER M WHERE F.MID = M.MID AND fNUM='1';
--�� ���� ����
DELETE FROM FILEBOARD F WHERE MID = 'AAA';
--��ȸ��
UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fNUM='1';
COMMIT;
SELECT FNUM FROM FILEBOARD;
--�����Խ��� ���
--�ۿ� ��� ��
SELECT COUNT(*)CNT FROM FREPLY WHERE FNUM='1';
--��� ���
SELECT FRNUM, FNUM, NVL2(MID,MID,AID),FRCONTENT,FRDATE, FRIP FROM FREPLY WHERE FNUM='16';
SELECT ROWNUM RN, F.* FROM (SELECT FRNUM, FNUM, NVL2(MID,MID,AID),FRCONTENT,FRDATE, FRIP FROM FREPLY WHERE FNUM='16')F;
   
SELECT FRNUM, FNUM, MID, nvl((select mname from member where mid=f.mid),'������') mname,FRCONTENT,FRRDATE, FRIP FROM FREPLY F where fnum=16 order by frnum desc;
SELECT * 
    FROM(SELECT ROWNUM RN, A.* 
        FROM (SELECT FRNUM, FNUM, MID, nvl((select mname from member where mid=f.mid),'������') mname,FRCONTENT,FRRDATE, FRIP FROM FREPLY F where fnum=16 order by frnum desc)A)
				WHERE rn between 1 and 10;
--��� �Է�
INSERT INTO FREPLY(fRNUM, fNUM, mID, aId, fRCONTENT, FRRDATE, FRIP ) VALUES(FREPLY_SEQ.NEXTVAL, 16, 'aaa',null, '��� Ȯ��',SYSDATE, '127.10.25' );
--��� ����
UPDATE FREPLY SET fRCONTENT= '���Ȯ�μ���' WHERE fRNUM=1;
--��� ����
DELETE FROM FREPLY WHERE fRNUM='2'; 
--��� dto
SELECT FRNUM, FNUM, M.MID, MNAME, FRCONTENT, FRRDATE, FRIP FROM FREPLY F, MEMBER M WHERE F.MID=M.MID AND FNUM=16;
--ȸ�� ����Ʈ(������)
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT mPHOTO, mID, mNAME FROM MVC_MEMBER ORDER BY mRDATE DESC)A)
    WHERE RN BETWEEN 1 AND 11;
--�� ����(������)
DELETE FROM FILEBOARD WHERE FNUM='2';


select * from freply where fnum=16;