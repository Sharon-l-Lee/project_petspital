--��� 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('aaa', '111', '���䳢', '95/01/01', 'M','bunny@naver.com', '010-0000-1111', '����� ������', '�䳢�� 425-8��'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('bbb', '111', '��߿�', '86/02/02', 'F','meow@gmail.com', '010-1111-2222', '����� ��걸', '�߿˷� 58-1��'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('ccc', '111', '�ָ۸�', '88/08/28', 'M','bowwow@gmail.com', '010-2222-3333', '����� ���빮��', '�۸۷� 751��'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('ddd', '111', '��±±', '99/05/12', 'F','bird085@naver.com', '010-3333-4444', '��⵵ �Ⱦ��', '±±�� 105-8��'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('eee', '111', '���߿�', '80/07/06', 'M','catty488@naver.com', '010-555-6666', '��⵵ ��õ��', '�߿˷� 425-9��');
    
--������
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin1', '111', '������'); --����� �̸��� ���� �� �����ڷ� (NVL)
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin2', '111', '������');
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin3', '111', '������');
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin4', '111', '������');
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin5', '111', '������');


--��������


--����

--���� ���
COMMIT;

--�����Խ���
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '����̸� �ֿ����ϴ�', 'ǰ�� ���� �Ǵ� �Ҵ㽺���� Ȳ�ݽô븦 �׸��Ͽ��°�? ���� ������ �׵��� ������ �̻� ������ �����ϰ� �̰��� ���� ������ �� �ΰ��� �ִ°�? �ΰ��� �� �� ���� �����ϰ� �ΰ��� ���� ���ٶ��̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'bbb', '�䳢�� �Ϳ����ϴ�', '���� ������, �̴� ��⸸ ���� �ǰ�, �ִ°�? �̻��� ���� ���̴� �����ϵ� �� ���. ���� ������ �λ��� ����� �ִ� ���̴�. ���� ���̸�, ������ ������ �� �۰� ���� Į�̴�. ��� �λ��� ����, ���� ������ ���� �縷�̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ccc', '�������� ��õ���ּ���', '���Ͽ��� ������ ǰ���� ���̴� �ǿ� �����̴�. ������ �ִ� ���Ͽ��� �׵��� ��Ⱑ ���̴�. ���� �����ϱ� �ǰ� �� �ִ°�? ���� ǰ����, ������ �ָ�, �װ��� ǰ�� ��ġ�� �縷�̴�. ǰ����, ������ ���̴� õ�ϸ� �󸶳� �̻��� �α� �׷��Ƿ� ���̴�. �ϴ� �� ������ �λ��� �ӿ��� ���´�.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ddd', '�߿˾߿˿�� �����', '�ǰ� ���� �Ǻΰ� ���, �Ҵ㽺���� ����� ����. ���� �����ϰ� ���̸� �װ��� �׵��� ����� Ȳ�ݽô��� �Ͽ�����, ���. ����, �󸶳� ���Ͽ��� �׵��� ������ ��ġ�� �ڽŰ� �Ǵ�. ���� �ҷ� ���ϱ� ����� �׵鿡�� �̴� ���꿡�� ���̴�. ���� �̴� â���� ������ �̻��� ��´�. �׷��Ƿ� �ٳ�� �츮�� ������ ���縦 �ִ� ������?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', '�۸� ¢�� ������', 'û���� ���Ͽ���, �Ͽ��� ���� �Ǵ� ���� ����. Ŀ�ٶ� �̰��� ��⿡�Լ� ����� �츮 �̻� �̻��� Į�̴�. �õ�� ������ ����� õ�ϸ� �������, ��߿� �𷡻��� ������ �ִ°�? ���� Ȳ�ݽô븦 Ǯ�� ����� �λ��� ���� Ŀ�ٶ� �𷡻��� ���̴�. ������ �̰��� ������ �� �̻��� ������ �λ��� ������ ���. �ż��� ������ ���� �ξ�, �Ǵ� �Ǵ� ���縦 ���̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '���� �Ǻκ� ���� ��õ���ּ���', 'ǰ�� ���� �Ǵ� �Ҵ㽺���� Ȳ�ݽô븦 �׸��Ͽ��°�? ���� ������ �׵��� ������ �̻� ������ �����ϰ� �̰��� ���� ������ �� �ΰ��� �ִ°�? �ΰ��� �� �� ���� �����ϰ� �ΰ��� ���� ���ٶ��̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'bbb', '���� �������� ��õ���ּ���', '���� ������, �̴� ��⸸ ���� �ǰ�, �ִ°�? �̻��� ���� ���̴� �����ϵ� �� ���. ���� ������ �λ��� ����� �ִ� ���̴�. ���� ���̸�, ������ ������ �� �۰� ���� Į�̴�. ��� �λ��� ����, ���� ������ ���� �縷�̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ccc', '���� ���Ƹ��� ��Ծ��', '���Ͽ��� ������ ǰ���� ���̴� �ǿ� �����̴�. ������ �ִ� ���Ͽ��� �׵��� ��Ⱑ ���̴�. ���� �����ϱ� �ǰ� �� �ִ°�? ���� ǰ����, ������ �ָ�, �װ��� ǰ�� ��ġ�� �縷�̴�. ǰ����, ������ ���̴� õ�ϸ� �󸶳� �̻��� �α� �׷��Ƿ� ���̴�. �ϴ� �� ������ �λ��� �ӿ��� ���´�.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ddd', '������ ���������� ���� �ֳ���', '�ǰ� ���� �Ǻΰ� ���, �Ҵ㽺���� ����� ����. ���� �����ϰ� ���̸� �װ��� �׵��� ����� Ȳ�ݽô��� �Ͽ�����, ���. ����, �󸶳� ���Ͽ��� �׵��� ������ ��ġ�� �ڽŰ� �Ǵ�. ���� �ҷ� ���ϱ� ����� �׵鿡�� �̴� ���꿡�� ���̴�. ���� �̴� â���� ������ �̻��� ��´�. �׷��Ƿ� �ٳ�� �츮�� ������ ���縦 �ִ� ������?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', '�� ¢���� �ʹ� ���մϴ�', 'û���� ���Ͽ���, �Ͽ��� ���� �Ǵ� ���� ����. Ŀ�ٶ� �̰��� ��⿡�Լ� ����� �츮 �̻� �̻��� Į�̴�. �õ�� ������ ����� õ�ϸ� �������, ��߿� �𷡻��� ������ �ִ°�? ���� Ȳ�ݽô븦 Ǯ�� ����� �λ��� ���� Ŀ�ٶ� �𷡻��� ���̴�. ������ �̰��� ������ �� �̻��� ������ �λ��� ������ ���. �ż��� ������ ���� �ξ�, �Ǵ� �Ǵ� ���縦 ���̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    
     INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', '���ο� ��å�θ� �߰��߽��ϴ�', 'û���� ���Ͽ���, �Ͽ��� ���� �Ǵ� ���� ����. Ŀ�ٶ� �̰��� ��⿡�Լ� ����� �츮 �̻� �̻��� Į�̴�. �õ�� ������ ����� õ�ϸ� �������, ��߿� �𷡻��� ������ �ִ°�? ���� Ȳ�ݽô븦 Ǯ�� ����� �λ��� ���� Ŀ�ٶ� �𷡻��� ���̴�. ������ �̰��� ������ �� �̻��� ������ �λ��� ������ ���. �ż��� ������ ���� �ξ�, �Ǵ� �Ǵ� ���縦 ���̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '�� �տ� �ִ� ���������� ����߾��Ф�', 'ǰ�� ���� �Ǵ� �Ҵ㽺���� Ȳ�ݽô븦 �׸��Ͽ��°�? ���� ������ �׵��� ������ �̻� ������ �����ϰ� �̰��� ���� ������ �� �ΰ��� �ִ°�? �ΰ��� �� �� ���� �����ϰ� �ΰ��� ���� ���ٶ��̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'bbb', '����� ��ǰ �����մϴ�', '���� ������, �̴� ��⸸ ���� �ǰ�, �ִ°�? �̻��� ���� ���̴� �����ϵ� �� ���. ���� ������ �λ��� ����� �ִ� ���̴�. ���� ���̸�, ������ ������ �� �۰� ���� Į�̴�. ��� �λ��� ����, ���� ������ ���� �縷�̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ccc', '�����̰� ��ģ�� �߰��߾��', '���Ͽ��� ������ ǰ���� ���̴� �ǿ� �����̴�. ������ �ִ� ���Ͽ��� �׵��� ��Ⱑ ���̴�. ���� �����ϱ� �ǰ� �� �ִ°�? ���� ǰ����, ������ �ָ�, �װ��� ǰ�� ��ġ�� �縷�̴�. ǰ����, ������ ���̴� õ�ϸ� �󸶳� �̻��� �α� �׷��Ƿ� ���̴�. �ϴ� �� ������ �λ��� �ӿ��� ���´�.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ddd', '�������� Ű���;��', '�ǰ� ���� �Ǻΰ� ���, �Ҵ㽺���� ����� ����. ���� �����ϰ� ���̸� �װ��� �׵��� ����� Ȳ�ݽô��� �Ͽ�����, ���. ����, �󸶳� ���Ͽ��� �׵��� ������ ��ġ�� �ڽŰ� �Ǵ�. ���� �ҷ� ���ϱ� ����� �׵鿡�� �̴� ���꿡�� ���̴�. ���� �̴� â���� ������ �̻��� ��´�. �׷��Ƿ� �ٳ�� �츮�� ������ ���縦 �ִ� ������?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', 'ĳ�͸� ��õ���ּ���', 'û���� ���Ͽ���, �Ͽ��� ���� �Ǵ� ���� ����. Ŀ�ٶ� �̰��� ��⿡�Լ� ����� �츮 �̻� �̻��� Į�̴�. �õ�� ������ ����� õ�ϸ� �������, ��߿� �𷡻��� ������ �ִ°�? ���� Ȳ�ݽô븦 Ǯ�� ����� �λ��� ���� Ŀ�ٶ� �𷡻��� ���̴�. ������ �̰��� ������ �� �̻��� ������ �λ��� ������ ���. �ż��� ������ ���� �ξ�, �Ǵ� �Ǵ� ���縦 ���̴�.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
   
--�����Խ��� ���
commit;

--QNA

--