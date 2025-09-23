package com.study.board;

import com.study.board.comment.CommentCommand;
import com.study.board.comment.CommentDAO;
import com.study.board.post.PostCommand;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Command command;
        String commandName = req.getParameter("command");

        System.out.println("** entered\ncommandName:"+commandName);
        if(commandName.contains("insert")){
            if(commandName.contains("comment")){
                command = new CommentCommand();

                command.insert(req, res);
            }
            else if(commandName.contains("post")){
                command = new PostCommand();
            } else return;

        }
        CommentDAO commentDAO = new CommentDAO();
        req.setAttribute("comments", commentDAO.selectComments(Integer.parseInt(req.getParameter("postid"))));
        RequestDispatcher rd = req.getRequestDispatcher("/boards/free/list/post/post.jsp");
        rd.forward(req, res);
    }

}
