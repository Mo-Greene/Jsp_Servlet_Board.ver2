package com.mogreene.jsp_servlet.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long bno;
    private String title;
    private String content;
    private String writer;
    private String regDate;
    private String modDate;
    private String password;
    private int view;
    private int cno;    //fk

}
