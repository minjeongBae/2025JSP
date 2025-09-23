package com.study.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Command {
    int update(HttpServletRequest req, HttpServletResponse res);
    int insert(HttpServletRequest req, HttpServletResponse res);
    int delete(HttpServletRequest req, HttpServletResponse res);
    Object getList(HttpServletRequest req, HttpServletResponse res);
}
