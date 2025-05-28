package org.scoula.lunch;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/lunch/random")
public class RandomLunchServlet extends HttpServlet {
    Map<String, Integer> voteLikeList = new HashMap<>();
    Map<String, Integer> voteDislikeList = new HashMap<>();

    public void init () {
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String [] menuList = {"쭈꾸미볶음", "김치찌개", "크림파스타", "부대찌개", "햄버거", "제육볶음"};
        int randomIndex = (int)(Math.random() * menuList.length);
        String voteMenu = request.getParameter("menu");
        String vote = request.getParameter("vote");
        PrintWriter out = response.getWriter();

//        voteList.put("쭈꾸미볶음", 0);
//        voteList.put("김치찌개", 0);
//        voteList.put("크림파스타", 0);
//        voteList.put("부대찌개", 0);
//        voteList.put("햄버거", 0);
//        voteList.put("제육볶음", 0);

        out.println("<html><body>");

        if (voteMenu != null) {
            if (vote.equals("like")) {
                voteLikeList.put(voteMenu, voteLikeList.getOrDefault(voteMenu, 0) + 1);
                System.out.println(voteLikeList.get(voteMenu));
            }
            else {
                voteDislikeList.put(voteMenu, voteDislikeList.getOrDefault(voteMenu, 0) + 1);
            }
            out.println("<h1>' " + voteMenu + "'에 대한 투표 결과</h1>");
            out.println("<p>\uD83D\uDC4D 좋아요: " + voteLikeList.getOrDefault(voteMenu, 0) + "</p>");
            out.println("<p>\uD83D\uDC4D 싫어요: " + voteDislikeList.getOrDefault(voteMenu, 0) + "</p>");
            out.println("<a href=/lunch/random><- 다시 추천받기</a>");
        }
        else {
            out.println("<h1>오늘의 점심 메뉴 추천</h1>");
            out.println("<b><p>" + menuList[randomIndex] + "</p></b>");
            out.println("<a href=/lunch/random?menu=" + menuList[randomIndex] + "&vote=like>\uD83D\uDC4D 좋아요</a>");
            out.println("<span>|</span>");
            out.println("<a href=/lunch/random?menu=" + menuList[randomIndex] + "&vote=dislike>\uD83D\uDC4E 싫어요</a>");
        }
        out.println("</body></html>");
    }

    public void destroy () {
    }
}
