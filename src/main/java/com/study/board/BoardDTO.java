package com.study.board;

import com.study.post.PostDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class BoardDTO {
    private List<PostDTO> posts;

    public void BoardDAO() {
        posts = new ArrayList<>();
    }

}
