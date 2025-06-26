package org.scoula.snack.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote-submit")
public class VoteSubmitServlet extends HttpServlet {

    protected void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String snack = req.getParameter("snack");
        req.setAttribute("snack", snack);
        res.setContentType("text/html; charset=UTF-8");
        Cookie c = new Cookie("lastSnack", snack);
        c.setMaxAge(3600);
        res.addCookie(c);

        RequestDispatcher dis = req.getRequestDispatcher("/vote_result.jsp");
        dis.forward(req, res);
    }
}