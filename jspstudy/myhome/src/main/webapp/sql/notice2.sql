DROP SEQUENCE NOTICE_SEQ;
CREATE SEQUENCE NOTICE_SEQ NOCACHE;

DROP TABLE NOTICE;
CREATE TABLE NOTICE (
	NOTICE_NO NUMBER NOT NULL,
	TITLE VARCHAR2(100 BYTE) NOT NULL,
	CREATE_DATE VARCHAR2(10 BYTE),
	CONSTRAINT PK_NOTICE PRIMARY KEY(NOTICE_NO)
);

INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지1', '20220101');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지2', '20220102');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지3', '20220103');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지4', '20220104');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지5', '20220105');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지6', '20220106');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지7', '20220107');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지8', '20220108');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지9', '20220109');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지10', '20220110');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지11', '20220101');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지12', '20220102');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지13', '20220103');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지14', '20220104');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지15', '20220105');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지16', '20220106');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지17', '20220107');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지18', '20220108');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지19', '20220109');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지20', '20220110');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지21', '20220101');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지22', '20220102');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지23', '20220103');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지24', '20220104');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지25', '20220105');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지26', '20220106');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지27', '20220107');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지28', '20220108');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지29', '20220109');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지30', '20220110');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지31', '20220101');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지32', '20220102');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지33', '20220103');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지34', '20220104');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지35', '20220105');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지36', '20220106');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지37', '20220107');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지38', '20220108');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지39', '20220109');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지40', '20220110');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지41', '20220101');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지42', '20220102');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지43', '20220103');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지44', '20220104');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지45', '20220105');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지46', '20220106');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지47', '20220107');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지48', '20220108');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지49', '20220109');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지50', '20220110');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지51', '20220101');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지52', '20220102');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지53', '20220103');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지54', '20220104');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지55', '20220105');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지56', '20220106');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지57', '20220107');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지58', '20220108');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지59', '20220109');
INSERT INTO NOTICE VALUES(NOTICE_SEQ.NEXTVAL, '긴급공지60', '20220110');
COMMIT;


DELETE FROM NOTICE WHERE NOTICE_NO=1;