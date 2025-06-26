package org.scoula.lunch;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/lunch")
public class LunchServlet extends HttpServlet {

    public void init (){
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String param = request.getParameter("mood");
        String menu;

        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (param == null) {
            out.println("<h1>오늘 기분은 어떤가요?</h1>");
            out.println("<form action=\"/lunch\" method=\"get\">");
            out.println("<select name=\"mood\">" +
                    "<option value=\"happy\">" + "기분 최고야" + "</option>" +
                    "<option value=\"soso\">" + "그냥 그래" + "</option>" +
                    "<option value=\"sad\">" + "우울해" + "</option>" +
                    "<option value=\"stressed\">" + "스트레스 쩔어" + "</option>" +
                    "</select><br/><br/>");
            out.println("<input type=submit value=\"추천 받기\">");
            out.println("</form>");
        }
        else {
            switch (param) {
                case "happy":
                    menu = "\uD83D\uDC19 매콤한 쭈꾸미볶음 추천!";
                    break;

                case "soso":
                    menu = "\uD83E\uDD58 든든한 김치찌개 어떠세요?";
                    break;

                case "sad":
                    menu = "\uD83C\uDF5D 부드러운 크림파스타로 위로받으세요.";
                    break;

                case "stressed":
                    menu = "\uD83D\uDD25 부대찌개 한 냄비 추천드려요!";
                    break;

                default:
                    menu = "\uD83C\uDF71 오늘은 도시락도 괜찮아요!";
                    break;

            }

            out.println("<h1>오늘의 추천 메뉴</h1>");
            out.println("<p>" + menu + "</p>");
            out.println("<a href=/lunch><- 다시 선택하기</a>");
        }
        out.println("</body></html>");
    }

    public void destroy () {
    }
}