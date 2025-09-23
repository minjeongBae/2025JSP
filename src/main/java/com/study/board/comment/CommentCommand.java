package com.study.board.comment;

import com.study.board.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

public class CommentCommand implements Command {
    @Override
    public int update(HttpServletRequest req, HttpServletResponse res) {
        return 0;
    }

    @Override
    public int insert(HttpServletRequest req, HttpServletResponse res) {
        CommentDAO commentDAO = new CommentDAO();
        return commentDAO.insertComment(Integer.parseInt(req.getParameter("postid")), req.getParameter("content"));
    }

    @Override
    public int delete(HttpServletRequest req, HttpServletResponse res) {
        return 0;
    }

    public List<CommentDTO> getComments(HttpServletRequest req, HttpServletResponse res) {
        CommentDAO commentDAO = new CommentDAO();
        List<CommentDTO> list = commentDAO.selectComments(Integer.parseInt(req.getParameter("postid")));
        return list;
    }
}
