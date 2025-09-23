package com.study.board.post;

import com.study.board.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

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

    @Override
    public Object getList(HttpServletRequest req, HttpServletResponse res) {
        PostDAO postDAO = new PostDAO();
        List<PostDTO> list = null;
        if(req.getParameter("frontDate") == null
            &&  req.getParameter("tailDate") == null
            &&   req.getParameter("searchWord") == null) {
            list = postDAO.selectPostsAll();
        } else {
            list = postDAO.selectPostsSearch(req.getParameter("frontDate")==null ?
                                        "" :  req.getParameter("frontDate") ,
                                        req.getParameter("tailDate")==null ?
                                            "" : req.getParameter("tailDate") ,
                                        req.getParameter("searchWord")==null ?
                                            "" : req.getParameter("searchWord") );
        }

        return list;
    }
}
