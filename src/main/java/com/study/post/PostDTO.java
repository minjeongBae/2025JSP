package com.study.post;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostDTO {
    private int postId;
    private String title;
    private String category;
    private String writer;
    private int views;
    private Date createDate;
    private Date updateDate;
    private String content;
    private int files;
}
