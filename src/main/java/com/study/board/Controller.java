package com.study.board;

import com.study.board.comment.CommentCommand;
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
        String commandName = "";
        if (req.getParameter("command")!=null) commandName = req.getParameter("command");
        RequestDispatcher rd = null;

        if(commandName.contains("insert")){
            if(commandName.contains("comment")){
                command = new CommentCommand();
                command.insert(req, res);

                rd = req.getRequestDispatcher("/boards/free/list/post/post.jsp");
                req.setAttribute("comments", command.getList(req, res));
            }
            else if(commandName.contains("post")){
                command = new PostCommand();
                rd = req.getRequestDispatcher("/boards/free/list/board.jsp");
                req.setAttribute("comments", command.getList(req, res));
            }
        } else if(commandName.contains("board")){
            command = new PostCommand();
            rd = req.getRequestDispatcher("/boards/free/list/board.jsp");
            req.setAttribute("board", command.getList(req, res));
        }
        else { // commandName == NULL
            command = new PostCommand();
            req.setAttribute("board", command.getList(req, res));
            rd = req.getRequestDispatcher("/boards/free/list/board.jsp");
        };

        rd.forward(req, res);
    }

}
