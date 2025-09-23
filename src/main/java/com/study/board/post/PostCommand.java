package com.study.board.post;

import com.study.board.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PostCommand implements Command {

    @Override
    public int update(HttpServletRequest req, HttpServletResponse res) {

        return 0;
    }

    @Override
    public int insert(HttpServletRequest req, HttpServletResponse res) {
        return 0;
    }

    @Override
    public int delete(HttpServletRequest req, HttpServletResponse res) {
        return 0;
    }
}
