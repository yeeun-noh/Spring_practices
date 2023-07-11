package org.zerock.domain;

import java.util.Date;

import lombok.Data;

/*
CREATE TABLE tbl_board(
    bno NUMBER(10,0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate date DEFAULT sysdate,
    updatedate date DEFAULT sysdate
);
*/

@Data
public class BoardVO {

	private Long bno; //!=long
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;

}
