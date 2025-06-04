package org.scoula.ex05;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        //속성 설정
        req.setAttribute("userid", "홍길동");
        req.setAttribute("passwd", "1234");

        RequestDispatcher dis = req.getRequestDispatcher("/login.jsp");
        dis.forward(req, res);
    }
}