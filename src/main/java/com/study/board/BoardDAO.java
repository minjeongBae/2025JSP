package com.study.board;

import com.study.post.PostDAO;
import com.study.post.PostDTO;

import java.util.List;

public class BoardDAO {

    public List<PostDTO> selectBoard() {
        try {
            PostDAO postDao = new PostDAO();
            return postDao.selectPostsAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<PostDTO> selectBoardSearchWord(String searchWord) {
        try {
            PostDAO postDao = new PostDAO();
            return postDao.selectPostsSearchWord(searchWord);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
