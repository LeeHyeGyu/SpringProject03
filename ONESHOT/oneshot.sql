
/* Drop Tables */

DROP TABLE OS_COMMENT CASCADE CONSTRAINTS;
DROP TABLE OS_CS CASCADE CONSTRAINTS;
DROP TABLE OS_MARK CASCADE CONSTRAINTS;
DROP TABLE OS_MSG CASCADE CONSTRAINTS;
DROP TABLE OS_ORDER_DETAIL CASCADE CONSTRAINTS;
DROP TABLE OS_ORDER CASCADE CONSTRAINTS;
DROP TABLE OS_REVIEW CASCADE CONSTRAINTS;
DROP TABLE OS_PRODUCT CASCADE CONSTRAINTS;
DROP TABLE OS_SOCIAL CASCADE CONSTRAINTS;
DROP TABLE OS_USER CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE CS_NO_SEQ;
DROP SEQUENCE MSG_NO_SEQ;
DROP SEQUENCE ORDER_NO_SEQ;
DROP SEQUENCE PRODUCT_NO_SEQ;
DROP SEQUENCE REVIEW_NO_SEQ;
DROP SEQUENCE SOCIAL_NO_SEQ;




/* Create Sequences */

CREATE SEQUENCE CS_NO_SEQ;
CREATE SEQUENCE MSG_NO_SEQ;
CREATE SEQUENCE ORDER_NO_SEQ;
CREATE SEQUENCE PRODUCT_NO_SEQ;
CREATE SEQUENCE REVIEW_NO_SEQ;
CREATE SEQUENCE SOCIAL_NO_SEQ;



/* Create Tables */

CREATE TABLE OS_COMMENT
(
	COMMENT_CONTENT varchar2(200) NOT NULL,
	COMMENT_DATE date NOT NULL,
	USER_ID varchar2(20) NOT NULL,
	SOCIAL_NO number NOT NULL
);


CREATE TABLE OS_CS
(
	CS_TITLE varchar2(50) NOT NULL,
	CS_CONTENT varchar2(1000) NOT NULL,
	CS_ANSWER varchar2(1000) NOT NULL,
	CS_CHECK number DEFAULT 0 NOT NULL,
	CS_SECTION varchar2(50) NOT NULL,
	CS_QUESTION_DATE date DEFAULT sysdate NOT NULL,
	CS_ANSWER_DATE date,
	CS_NO number NOT NULL,
	USER_ID varchar2(20) NOT NULL,
	PRODUCT_NO number NOT NULL,
	PRIMARY KEY (CS_NO)
);


CREATE TABLE OS_MARK
(
	MARK_NO number NOT NULL,
	PRODUCT_NO number NOT NULL,
	USER_ID varchar2(20) NOT NULL,
	MARK_DATE date DEFAULT SYSDATE,
	PRIMARY KEY (MARK_NO)
);


CREATE TABLE OS_MSG
(
	MSG_NO number NOT NULL,
	MSG_CONTENT varchar2(500) NOT NULL,
	MSG_DATE date DEFAULT sysdate NOT NULL,
	USER_ID varchar2(20) NOT NULL,
	MSG_RECV varchar2(20),
	PRIMARY KEY (MSG_NO)
);


CREATE TABLE OS_ORDER
(
	ORDER_NO varchar2(50) NOT NULL,
	ORDER_QTY number NOT NULL,
	ORDER_DELIVERY number NOT NULL,
	ORDER_ADDR varchar2(300) NOT NULL,
	PRODUCT_NO number NOT NULL,
	USER_ID varchar2(20) NOT NULL,
	PRIMARY KEY (ORDER_NO)
);


CREATE TABLE OS_ORDER_DETAIL
(
	ORDER_DETAIL_QTY number NOT NULL,
	ORDER_NO varchar2(50) NOT NULL,
	PRODUCT_NO number NOT NULL
);


CREATE TABLE OS_PRODUCT
(
	PRODUCT_NO number NOT NULL,
	PRODUCT_NAME varchar2(100) NOT NULL,
	PRODUCT_PRICE number NOT NULL,
	PRODUCT_SALES_QTY number,
	PRODUCT_STOCK_QTY number,
	PRODUCT_ACID varchar2(20) NOT NULL,
	PRODUCT_SUGAR varchar2(15) NOT NULL,
	PRODUCT_ALC number NOT NULL,
	PRODUCT_SIZE number NOT NULL,
	PRODUCT_INFO varchar2(1000) NOT NULL,
	PRODUCT_DATE date DEFAULT SYSDATE,
	PRIMARY KEY (PRODUCT_NO)
);


CREATE TABLE OS_REVIEW
(
	REVIEW_RATING number NOT NULL,
	REVIEW_NO number NOT NULL,
	REVIEW_TITLE varchar2(100) NOT NULL,
	REVIEW_CONTENT varchar2(300) NOT NULL,
	USER_ID varchar2(20) NOT NULL,
	PRODUCT_NO number NOT NULL,
	REVIEW_DATE date DEFAULT SYSDATE,
	PRIMARY KEY (REVIEW_NO)
);


CREATE TABLE OS_SOCIAL
(
	SOCIAL_NO number NOT NULL,
	SOCIAL_TITLE varchar2(30) NOT NULL,
	SOCIAL_CONTENT varchar2(1000) NOT NULL,
	SOCIAL_SECTION number NOT NULL,
	SOCIAL_DATE date DEFAULT sysdate NOT NULL,
	USER_ID varchar2(20) NOT NULL,
	SOCIAL_COUNT number DEFAULT 0,
	EVENT_DATE date,
	DEADLINE date,
	MAXP number,
	JOIN_STAT number,
	JOIN_LIST varchar2(50),
	PRIMARY KEY (SOCIAL_NO)
);


CREATE TABLE OS_USER
(
	USER_ID varchar2(20) NOT NULL,
	USER_PW varchar2(128) NOT NULL,
	USER_ADR varchar2(50 char) NOT NULL,
	USER_LEVEL number DEFAULT 0 NOT NULL,
	USER_WARN number DEFAULT 0 NOT NULL,
	USER_JUMIN number NOT NULL,
	USER_PRICE number,
	USER_SUGAR number,
	USER_ACID number,
	USER_PERSIM number,
	USER_BUBBLE number,
	PRIMARY KEY (USER_ID)
);



/* Create Foreign Keys */

ALTER TABLE OS_ORDER_DETAIL
	ADD FOREIGN KEY (ORDER_NO)
	REFERENCES OS_ORDER (ORDER_NO)
;


ALTER TABLE OS_CS
	ADD FOREIGN KEY (PRODUCT_NO)
	REFERENCES OS_PRODUCT (PRODUCT_NO)
;


ALTER TABLE OS_MARK
	ADD FOREIGN KEY (PRODUCT_NO)
	REFERENCES OS_PRODUCT (PRODUCT_NO)
;


ALTER TABLE OS_ORDER
	ADD FOREIGN KEY (PRODUCT_NO)
	REFERENCES OS_PRODUCT (PRODUCT_NO)
;


ALTER TABLE OS_ORDER_DETAIL
	ADD FOREIGN KEY (PRODUCT_NO)
	REFERENCES OS_PRODUCT (PRODUCT_NO)
;


ALTER TABLE OS_REVIEW
	ADD FOREIGN KEY (PRODUCT_NO)
	REFERENCES OS_PRODUCT (PRODUCT_NO)
;


ALTER TABLE OS_COMMENT
	ADD FOREIGN KEY (SOCIAL_NO)
	REFERENCES OS_SOCIAL (SOCIAL_NO)
;


ALTER TABLE OS_COMMENT
	ADD FOREIGN KEY (USER_ID)
	REFERENCES OS_USER (USER_ID)
;


ALTER TABLE OS_CS
	ADD FOREIGN KEY (USER_ID)
	REFERENCES OS_USER (USER_ID)
;


ALTER TABLE OS_MARK
	ADD FOREIGN KEY (USER_ID)
	REFERENCES OS_USER (USER_ID)
;


ALTER TABLE OS_MSG
	ADD FOREIGN KEY (USER_ID)
	REFERENCES OS_USER (USER_ID)
;


ALTER TABLE OS_ORDER
	ADD FOREIGN KEY (USER_ID)
	REFERENCES OS_USER (USER_ID)
;


ALTER TABLE OS_REVIEW
	ADD FOREIGN KEY (USER_ID)
	REFERENCES OS_USER (USER_ID)
;


ALTER TABLE OS_SOCIAL
	ADD FOREIGN KEY (USER_ID)
	REFERENCES OS_USER (USER_ID)
;



