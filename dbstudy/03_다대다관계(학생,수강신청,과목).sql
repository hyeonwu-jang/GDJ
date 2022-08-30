/*
    수강신청
    1. 여러 학생이 여러 과목을 신청하는 다대다관계
    2. 학생-과목의 직접적인 다대다관계 설정은 불가능
    3. 학생-수강신청-과목으로 일대다관계 2개 설정으로 진행
*/
/*
    참고. 외래키 제약조건을 무시하고 테이블 삭제
    순서에 상관없이 삭제할 수 있음
    DROP TABLE STUDENT CASCADE CONSTRAINTS;
    DROP TABLE SUBJECT CASCADE CONSTRAINTS;
    DROP TABLE ENROLL  CASCADE CONSTRAINTS;
*/

DROP TABLE ENROLL;
DROP TABLE STUDENT;
DROP TABLE SUBJECT;

-- 학생 테이블 생성
CREATE TABLE STUDENT (
    STU_NO    VARCHAR2(5 BYTE)  NOT NULL,
    STU_NAME  VARCHAR2(15 BYTE) NULL,
    STU_AGE   NUMBER(3)         NULL,
    CONSTRAINT PK_STUDENT PRIMARY KEY(STU_NO)
);
-- 과목 테이블 생성
CREATE TABLE SUBJECT (
    SUB_CODE  VARCHAR2(1 BYTE)  NOT NULL,
    SUB_NAME  VARCHAR2(10 BYTE) NULL,
    PROFESSOR VARCHAR2(15 BYTE) NULL,
    CONSTRAINT PK_SUBJECT PRIMARY KEY(SUB_CODE)
);
-- 수강신청 테이블 생성
CREATE TABLE ENROLL (
    ENROLL_NO NUMBER           NOT NULL,
    STU_NO    VARCHAR2(5 BYTE) NOT NULL,
    SUB_CODE  VARCHAR2(1 BYTE) NOT NULL,
    CONSTRAINT PK_ENROLL PRIMARY KEY(ENROLL_NO),
    CONSTRAINT FK_ENROLL_STUDENT FOREIGN KEY(STU_NO) REFERENCES STUDENT(STU_NO),
    CONSTRAINT FK_ENROLL_SUBJECT FOREIGN KEY(SUB_CODE) REFERENCES SUBJECT(SUB_CODE)
);