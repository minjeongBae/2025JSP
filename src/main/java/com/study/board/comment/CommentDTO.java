package com.study.board.comment;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDTO {
    private String content;
    private String writer;
    private Date createDate;
    private int postId;
    private int cId;
}
