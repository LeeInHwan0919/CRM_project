   
CREATE TABLE BOARD_FILE(
FILE_SEQ NUMBER PRIMARY KEY, --첨부파일 번호
BOARD_SEQ NUMBER, --게시판 번호
FILE_SIZE VARCHAR(50) NOT NULL,-- 첨부파일 사이즈
FILE_FOLDER VARCHAR(500) NOT NULL,--첨부파일 경로
FILE_NAME VARCHAR(50) NOT NULL --청부파일 이름
--CONSTRAINT "FILE_FK" FOREIGN KEY ("BOARD_SEQ") REFERENCES BOARD ("SEQ")
);

-- alter table BOARD_FILE add DELETE_YN VARCHAR2(5);
CREATE SEQUENCE FILE_SEQ INCREMENT BY 1 START WITH 1;

SELECT * FROM BOARD_FILE;

--DROP TABLE BOARD_FILE ;

INSERT INTO BOARD_FILE 
(	FILE_SEQ,
	BOARD_SEQ,
	FILE_SIZE,
	FILE_FOLDER,
	FILE_NAME
) 
VLAUSE (
	FILE_SEQ.NEXTVAL,
	#{board_seq},
	#{file_size},
	#{file_folder},
	#{file_name}
)


SELECT *FROM BOARD_FILE;