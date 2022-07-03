--멤버 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('aaa', '111', '이토끼', '95/01/01', 'M','bunny@naver.com', '010-0000-1111', '서울시 강남구', '토끼로 425-8길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('bbb', '111', '김야옹', '86/02/02', 'F','meow@gmail.com', '010-1111-2222', '서울시 용산구', '야옹로 58-1길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('ccc', '111', '주멍멍', '88/08/28', 'M','bowwow@gmail.com', '010-2222-3333', '서울시 서대문구', '멍멍로 751길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('ddd', '111', '박짹짹', '99/05/12', 'F','bird085@naver.com', '010-3333-4444', '경기도 안양시', '짹짹로 105-8길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('eee', '111', '서야옹', '80/07/06', 'M','catty488@naver.com', '010-555-6666', '경기도 과천시', '야옹로 425-9길');
    
--관리자
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin1', '111', '관리자'); --사용자 이름이 없을 시 관리자로 (NVL)
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin2', '111', '관리자');
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin3', '111', '관리자');
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin4', '111', '관리자');
INSERT INTO ADMIN (aID, aPW, aNAME) VALUES ('admin5', '111', '관리자');
SELECT * FROM ADMIN WHERE aID = 'admin1';
SELECT * FROM ADMIN;
commit;
--공지사항


--병원

--병원 댓글
COMMIT;

--자유게시판
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '고양이를 주웠습니다', '품에 싹이 피는 소담스러운 황금시대를 그리하였는가? 것은 구하지 그들의 무한한 이상 고행을 현저하게 이것은 전인 긴지라 뭇 인간에 있는가? 인간의 든 새 고동을 현저하게 인간은 것은 봄바람이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'bbb', '토끼는 귀엽습니다', '못할 할지니, 이는 듣기만 새가 피고, 있는가? 이상이 것은 보이는 투명하되 꽃 운다. 고동을 때까지 인생에 붙잡아 있는 뿐이다. 길을 바이며, 따뜻한 미인을 뭇 작고 것은 칼이다. 우는 인생을 돋고, 것은 끝까지 몸이 사막이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ccc', '동물병원 추천해주세요', '위하여서 얼음과 품었기 보이는 피에 때문이다. 구하지 주는 위하여서 그들의 용기가 말이다. 밥을 발휘하기 피가 수 있는가? 가장 품으며, 무엇을 주며, 그것은 품고 가치를 사막이다. 품으며, 과실이 보이는 천하를 얼마나 이상의 두기 그러므로 것이다. 하는 이 원질이 인생에 속에서 끓는다.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ddd', '야옹야옹우는 고양이', '피가 새가 피부가 대고, 소담스러운 목숨이 보라. 남는 현저하게 찬미를 그것을 그들은 목숨이 황금시대의 하였으며, 운다. 돋고, 얼마나 위하여서 그들의 만물은 가치를 자신과 피다. 가장 불러 구하기 사람은 그들에게 이는 설산에서 것이다. 가는 이는 창공에 생명을 이상의 듣는다. 그러므로 뛰노는 우리의 가슴에 역사를 있는 있으랴?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', '멍멍 짖는 강아지', '청춘을 위하여서, 일월과 끓는 피는 고동을 보라. 커다란 이것은 노년에게서 목숨이 우리 이상 이상은 칼이다. 시들어 열락의 사랑의 천하를 살았으며, 산야에 모래뿐일 얼음과 있는가? 못할 황금시대를 풀이 물방아 인생에 것은 커다란 모래뿐일 뿐이다. 열락의 이것은 내려온 뭇 이상의 가슴에 인생을 가지에 운다. 거선의 긴지라 것은 맺어, 피는 되는 역사를 뿐이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '동물 피부병 병원 추천해주세요', '품에 싹이 피는 소담스러운 황금시대를 그리하였는가? 것은 구하지 그들의 무한한 이상 고행을 현저하게 이것은 전인 긴지라 뭇 인간에 있는가? 인간의 든 새 고동을 현저하게 인간은 것은 봄바람이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'bbb', '작은 동물병원 추천해주세요', '못할 할지니, 이는 듣기만 새가 피고, 있는가? 이상이 것은 보이는 투명하되 꽃 운다. 고동을 때까지 인생에 붙잡아 있는 뿐이다. 길을 바이며, 따뜻한 미인을 뭇 작고 것은 칼이다. 우는 인생을 돋고, 것은 끝까지 몸이 사막이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ccc', '딸이 병아리를 사왔어요', '위하여서 얼음과 품었기 보이는 피에 때문이다. 구하지 주는 위하여서 그들의 용기가 말이다. 밥을 발휘하기 피가 수 있는가? 가장 품으며, 무엇을 주며, 그것은 품고 가치를 사막이다. 품으며, 과실이 보이는 천하를 얼마나 이상의 두기 그러므로 것이다. 하는 이 원질이 인생에 속에서 끓는다.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ddd', '복막염 수술가능한 병원 있나요', '피가 새가 피부가 대고, 소담스러운 목숨이 보라. 남는 현저하게 찬미를 그것을 그들은 목숨이 황금시대의 하였으며, 운다. 돋고, 얼마나 위하여서 그들의 만물은 가치를 자신과 피다. 가장 불러 구하기 사람은 그들에게 이는 설산에서 것이다. 가는 이는 창공에 생명을 이상의 듣는다. 그러므로 뛰노는 우리의 가슴에 역사를 있는 있으랴?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', '개 짖음이 너무 심합니다', '청춘을 위하여서, 일월과 끓는 피는 고동을 보라. 커다란 이것은 노년에게서 목숨이 우리 이상 이상은 칼이다. 시들어 열락의 사랑의 천하를 살았으며, 산야에 모래뿐일 얼음과 있는가? 못할 황금시대를 풀이 물방아 인생에 것은 커다란 모래뿐일 뿐이다. 열락의 이것은 내려온 뭇 이상의 가슴에 인생을 가지에 운다. 거선의 긴지라 것은 맺어, 피는 되는 역사를 뿐이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    
     INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', '새로운 산책로를 발견했습니다', '청춘을 위하여서, 일월과 끓는 피는 고동을 보라. 커다란 이것은 노년에게서 목숨이 우리 이상 이상은 칼이다. 시들어 열락의 사랑의 천하를 살았으며, 산야에 모래뿐일 얼음과 있는가? 못할 황금시대를 풀이 물방아 인생에 것은 커다란 모래뿐일 뿐이다. 열락의 이것은 내려온 뭇 이상의 가슴에 인생을 가지에 운다. 거선의 긴지라 것은 맺어, 피는 되는 역사를 뿐이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'aaa', '집 앞에 있던 동물병원이 폐업했어요ㅠㅠ', '품에 싹이 피는 소담스러운 황금시대를 그리하였는가? 것은 구하지 그들의 무한한 이상 고행을 현저하게 이것은 전인 긴지라 뭇 인간에 있는가? 인간의 든 새 고동을 현저하게 인간은 것은 봄바람이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'bbb', '고양이 용품 나눔합니다', '못할 할지니, 이는 듣기만 새가 피고, 있는가? 이상이 것은 보이는 투명하되 꽃 운다. 고동을 때까지 인생에 붙잡아 있는 뿐이다. 길을 바이며, 따뜻한 미인을 뭇 작고 것은 칼이다. 우는 인생을 돋고, 것은 끝까지 몸이 사막이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ccc', '길고양이가 다친걸 발견했어요', '위하여서 얼음과 품었기 보이는 피에 때문이다. 구하지 주는 위하여서 그들의 용기가 말이다. 밥을 발휘하기 피가 수 있는가? 가장 품으며, 무엇을 주며, 그것은 품고 가치를 사막이다. 품으며, 과실이 보이는 천하를 얼마나 이상의 두기 그러므로 것이다. 하는 이 원질이 인생에 속에서 끓는다.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'ddd', '강아지를 키우고싶어요', '피가 새가 피부가 대고, 소담스러운 목숨이 보라. 남는 현저하게 찬미를 그것을 그들은 목숨이 황금시대의 하였으며, 운다. 돋고, 얼마나 위하여서 그들의 만물은 가치를 자신과 피다. 가장 불러 구하기 사람은 그들에게 이는 설산에서 것이다. 가는 이는 창공에 생명을 이상의 듣는다. 그러므로 뛰노는 우리의 가슴에 역사를 있는 있으랴?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'eee', '캐터리 추천해주세요', '청춘을 위하여서, 일월과 끓는 피는 고동을 보라. 커다란 이것은 노년에게서 목숨이 우리 이상 이상은 칼이다. 시들어 열락의 사랑의 천하를 살았으며, 산야에 모래뿐일 얼음과 있는가? 못할 황금시대를 풀이 물방아 인생에 것은 커다란 모래뿐일 뿐이다. 열락의 이것은 내려온 뭇 이상의 가슴에 인생을 가지에 운다. 거선의 긴지라 것은 맺어, 피는 되는 역사를 뿐이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
   
--자유게시판 댓글
commit;
select * from member;
--QNA

--