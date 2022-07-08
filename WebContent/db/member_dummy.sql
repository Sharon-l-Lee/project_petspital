--멤버 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test1', '111', '이토끼', '95/01/01', 'M','rabbit@gmail.com', '010-0000-1111', '서울시 강남구', '토끼로 425-8길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test2', '111', '김야옹', '86/02/02', 'F','love25@naver.com', '010-1111-2222', '서울시 용산구', '야옹로 58-1길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test3', '111', '주멍멍', '88/08/28', 'M','bowwow@naver.com', '010-2222-3333', '서울시 서대문구', '멍멍로 751길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test4', '111', '박짹짹', '99/05/12', 'F','bird085@gmail.com', '010-3333-4444', '경기도 안양시', '짹짹로 105-8길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test5', '111', '서야옹', '80/07/06', 'M','catty488@gmail.com', '010-555-6666', '경기도 과천시', '야옹로 425-9길');
    
    
    INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test6', '111', '이야옹', '95/01/01', 'M','cat@gmail.com', '010-0000-1111', '서울시 강남구', '토끼로 425-8길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test7', '111', '윤찍찍', '86/02/02', 'F','rhdiddl90@naver.com', '010-1111-2222', '서울시 용산구', '야옹로 58-1길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test8', '111', '박토끼', '88/08/28', 'M','wonder124@naver.com', '010-2222-3333', '서울시 서대문구', '멍멍로 751길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test9', '111', '김고슴', '99/05/12', 'F','mybuddy74@gmail.com', '010-3333-4444', '경기도 안양시', '짹짹로 105-8길'); 
INSERT INTO MEMBER (mID, mPW, mNAME, mBIRTH, mGENDER, mEMAIL, mPHONE,  mADDRESS, mADDRESS2)
    VALUES ('test10', '111', '이햄찌', '80/07/06', 'M','likeyou011@gmail.com', '010-555-6666', '경기도 과천시', '야옹로 425-9길');
    
    commit;
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
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test1', '고양이를 주웠습니다', '품에 싹이 피는 소담스러운 황금시대를 그리하였는가? 것은 구하지 그들의 무한한 이상 고행을 현저하게 이것은 전인 긴지라 뭇 인간에 있는가? 인간의 든 새 고동을 현저하게 인간은 것은 봄바람이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test2', '토끼는 귀엽습니다', '못할 할지니, 이는 듣기만 새가 피고, 있는가? 이상이 것은 보이는 투명하되 꽃 운다. 고동을 때까지 인생에 붙잡아 있는 뿐이다. 길을 바이며, 따뜻한 미인을 뭇 작고 것은 칼이다. 우는 인생을 돋고, 것은 끝까지 몸이 사막이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test3', '동물병원 추천해주세요', '위하여서 얼음과 품었기 보이는 피에 때문이다. 구하지 주는 위하여서 그들의 용기가 말이다. 밥을 발휘하기 피가 수 있는가? 가장 품으며, 무엇을 주며, 그것은 품고 가치를 사막이다. 품으며, 과실이 보이는 천하를 얼마나 이상의 두기 그러므로 것이다. 하는 이 원질이 인생에 속에서 끓는다.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test4', '야옹야옹우는 고양이', '피가 새가 피부가 대고, 소담스러운 목숨이 보라. 남는 현저하게 찬미를 그것을 그들은 목숨이 황금시대의 하였으며, 운다. 돋고, 얼마나 위하여서 그들의 만물은 가치를 자신과 피다. 가장 불러 구하기 사람은 그들에게 이는 설산에서 것이다. 가는 이는 창공에 생명을 이상의 듣는다. 그러므로 뛰노는 우리의 가슴에 역사를 있는 있으랴?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test5', '멍멍 짖는 강아지', '청춘을 위하여서, 일월과 끓는 피는 고동을 보라. 커다란 이것은 노년에게서 목숨이 우리 이상 이상은 칼이다. 시들어 열락의 사랑의 천하를 살았으며, 산야에 모래뿐일 얼음과 있는가? 못할 황금시대를 풀이 물방아 인생에 것은 커다란 모래뿐일 뿐이다. 열락의 이것은 내려온 뭇 이상의 가슴에 인생을 가지에 운다. 거선의 긴지라 것은 맺어, 피는 되는 역사를 뿐이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test6', '동물 피부병 병원 추천해주세요', '품에 싹이 피는 소담스러운 황금시대를 그리하였는가? 것은 구하지 그들의 무한한 이상 고행을 현저하게 이것은 전인 긴지라 뭇 인간에 있는가? 인간의 든 새 고동을 현저하게 인간은 것은 봄바람이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test7', '작은 동물병원 추천해주세요', '못할 할지니, 이는 듣기만 새가 피고, 있는가? 이상이 것은 보이는 투명하되 꽃 운다. 고동을 때까지 인생에 붙잡아 있는 뿐이다. 길을 바이며, 따뜻한 미인을 뭇 작고 것은 칼이다. 우는 인생을 돋고, 것은 끝까지 몸이 사막이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test8', '딸이 병아리를 사왔어요', '위하여서 얼음과 품었기 보이는 피에 때문이다. 구하지 주는 위하여서 그들의 용기가 말이다. 밥을 발휘하기 피가 수 있는가? 가장 품으며, 무엇을 주며, 그것은 품고 가치를 사막이다. 품으며, 과실이 보이는 천하를 얼마나 이상의 두기 그러므로 것이다. 하는 이 원질이 인생에 속에서 끓는다.',  NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test9', '복막염 수술가능한 병원 있나요', '피가 새가 피부가 대고, 소담스러운 목숨이 보라. 남는 현저하게 찬미를 그것을 그들은 목숨이 황금시대의 하였으며, 운다. 돋고, 얼마나 위하여서 그들의 만물은 가치를 자신과 피다. 가장 불러 구하기 사람은 그들에게 이는 설산에서 것이다. 가는 이는 창공에 생명을 이상의 듣는다. 그러므로 뛰노는 우리의 가슴에 역사를 있는 있으랴?', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    INSERT INTO FILEBOARD (fNUM, MID, fSUBJECT, fCONTENT, fFILENAME, fFILENAME2, fFILENAME3, fGROUP, fSTEP, fINDENT, fIP)
    VALUES(FILEBOARD_SEQ.NEXTVAL, 'test10', '개 짖음이 너무 심합니다', '청춘을 위하여서, 일월과 끓는 피는 고동을 보라. 커다란 이것은 노년에게서 목숨이 우리 이상 이상은 칼이다. 시들어 열락의 사랑의 천하를 살았으며, 산야에 모래뿐일 얼음과 있는가? 못할 황금시대를 풀이 물방아 인생에 것은 커다란 모래뿐일 뿐이다. 열락의 이것은 내려온 뭇 이상의 가슴에 인생을 가지에 운다. 거선의 긴지라 것은 맺어, 피는 되는 역사를 뿐이다.', NULL, NULL, NULL, FILEBOARD_SEQ.CURRVAL, 0, 0, '127.10.26');
    
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
--QNA 질문
rollback;
select * from member;

INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'bbb', '강아지가 갑자기 이상 행동을 합니다', '강아지가 갑자기 이상 행동을 합니다', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );

INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test1', '강아지가 아픈 것 같아요', '
그와 만물은 내려온 앞이 뿐이다. 인생에 영원히 산야에 맺어, 있는 우는 착목한는 것이다. 이성은 그들의 우리 인간의 유소년에게서 두기 같이 교향악이다. 새 얼음 유소년에게서 같은 영락과 것이다. 풀이 인생에 피고, 천자만홍이 이 우리의 거친 행복스럽고 봄바람이다. 않는 같은 목숨을 가슴에 구하기 청춘의 위하여, 사막이다. 이성은 위하여, 위하여 청춘을 끓는다.', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
    
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test2', '토끼 귀에서 진물이 나와요', '웅대한 청춘의 없으면, 공자는 찬미를 얼음과 우리는 눈에 철환하였는가? 능히 이상의 튼튼하며, 피가 같은 이 더운지라 때문이다. 황금시대를 위하여 길지 곳으로 소담스러운 운다. 싸인 역사를 가슴이 그와 풀이 이상 듣기만 되는 피부가 이것이다. 들어 그들은 품으며, 때문이다. 그들은 예수는 이상은 놀이 사는가 이것은 용감하고 실로 것이다. 불러 옷을 이상, 그들의 심장의 없으면 예가 만천하의 그것을 그리하였는가?', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
    
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test3', '고양이 복막염 질문드립니다', '인생을 희망의 영락과 따뜻한 눈이 천자만홍이 심장의 인간에 뿐이다. 설레는 든 끝까지 가는 찾아 아니더면, 곧 것이 그리하였는가? 돋고, 품고 품으며, 위하여서, 내는 뼈 없는 뿐이다. 구할 풍부하게 만물은 가치를 있을 이것이다. 많이 인간의 크고 풀이 끓는 풀이 착목한는 것은 뿐이다. 길을 위하여, 날카로우나 천지는 이는 인간의 투명하되 것이다.', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test4', '얼마전에 병원을 다녀왔는데', '인류의 살았으며, 물방아 작고 새가 눈이 부패뿐이다. 용감하고 트고, 위하여 인간은 너의 굳세게 듣는다. 시들어 실로 아니한 오직 이상의 생명을 그러므로 사막이다. 인간의 천고에 보이는 구하기 구하지 있다. 인생을 인생의 것은 열매를 위하여, 이상 피어나기 때문이다. 사람은 인생을 창공에 있는가?', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
    
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test5', '고양이 전문 병원에서 수의사분 진단', '청춘의 몸이 목숨이 이성은 따뜻한 노래하며 품으며, 말이다. 불어 두기 인간의 품었기 희망의 미묘한 교향악이다. 모래뿐일 맺어, 남는 예가 위하여 간에 가는 약동하다. 웅대한 청춘의 바로 오아이스도 것은 이는 그들에게 같이, 것이다. 돋고, 뼈 때에, 것이다. 두손을 피고 피가 우리 사는가 수 피어나기 없으면, 보내는 것이다.', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
    
    INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test6', '합사를 시작했는데 너무 많이 싸워요', '얼마나 아름답고 풀밭에 보이는 길지 발휘하기 살았으며, 봄바람이다. 가치를 미인을 천지는 사라지지 예가 것은 부패뿐이다. 위하여서 뭇 많이 실로 인간에 것이다. 따뜻한 바이며, 원대하고, 이상을 설산에서 얼음에 피다. 천고에 불러 청춘에서만 용감하고 것은 방지하는 살 이것을 하는 칼이다.', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
    
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test7', '저희집 애가 자꾸 재채기를 합니다', '풍부하게 뛰노는 보는 착목한는 하여도 못할 설레는 쓸쓸한 그러므로 듣는다. 얼음이 우리는 가는 그것을 두기 인생에 꽃 낙원을 피다. 인도하겠다는 트고, 아름답고 운다. 뜨거운지라, 것이다.보라, 찾아다녀도, 그러므로 뼈 이성은 가지에 품에 앞이 피다. 고행을 같은 불어 피다.', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
    
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test4', '뒷발에 이거 뭔가요? 병원에 가야할까요?', '피부가 청춘 열락의 인생을 이상의 그들은 아니다. 하여도 작고 품으며, 이상, 황금시대다. 위하여서 커다란 소리다.이것은 보는 남는 때문이다. 피가 청춘의 희망의 실현에 들어 따뜻한 가슴에 못할 보라. 든 그들의 영락과 반짝이는 것이다. 있을 원질이 하는 풀이 가는 이것이다. 할지니, 피고, 생명을 용감하고 이것이다.', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test2', '수술하면 어떻게 해야하나요', '소금이라 갑 이상 오직 낙원을 황금시대다. 인간에 곳이 그것은 피고, 것이다. 무엇이 아니더면, 원대하고, 교향악이다. 그들은 바이며, 이상의 돋고, 것이 오직 끝에 실로 오아이스도 이것이다. 듣기만 웅대한 대중을 황금시대의 이상 바이며, 인생에 그들의 만물은 칼이다.', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );
    
INSERT INTO QNA (qNUM, mID, qSUBJECT, qCONTENT, qFILENAME, qRDATE, qGROUP, qSTEP, qINDENT, qIP) 
    VALUES (QNA_SEQ.NEXTVAL, 'test1', '고양이 흰자가 빨갛게됐어요', '피부가 되는 청춘이 있는 사막이다. 가는 불러 못할 이상, 그들에게 보이는 위하여 이상의 생생하며, 것이다. 반짝이는 그러므로 피가 하여도 같이 길을 이는 주며, 꽃이 힘있다. 사는가 능히 놀이 있는 뿐이다. 그들의 행복스럽고 하였으며, 공자는 칼이다. 청춘 못하다 시들어 목숨이 내는 생명을 무엇이 이상은 사막이다. 영락과 봄날의 없는 끓는 웅대한 있으랴?', NULL, SYSDATE, QNA_SEQ.CURRVAL,0,0,'125.10.15'
    );


--