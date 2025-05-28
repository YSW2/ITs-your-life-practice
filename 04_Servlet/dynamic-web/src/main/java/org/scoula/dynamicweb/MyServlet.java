package org.scoula.dynamicweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = {"/xxx", "/yyy"})
public class MyServlet extends HttpServlet {

    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        System.out.println("HelloServlet 요청");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Hello Servlet</h1>");

    }
}
