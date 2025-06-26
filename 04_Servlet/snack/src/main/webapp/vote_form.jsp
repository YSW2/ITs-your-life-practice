<%--
  Created by IntelliJ IDEA.
  User: jrgyb
  Date: 25. 6. 4.
  Time: 오후 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${cookie.containsKey('lastSnack')}">
    <p><b>최근에 고른 간식: ${cookie.get('lastSnack').value}</b></p>
    <p>이 간식을 다시 드셔보는 건 어떠세요?</p>
</c:if>
<c:if test="${sessionScope.visitTime != null}">
    <p>최근 방문 시간: ${sessionScope.visitTime}</p>
</c:if>
<h1>🍪 우리 반 인기 간식 투표</h1>
<form action="vote-submit" method="post">
    <fieldset>
        <legend>좋아하는 간식을 하나 골라주세요</legend>
        <ul style="list-style: none">
            <li>
                <input type="radio" name="snack" value="와사비과자" id="와사비과자">
                <label for="와사비과자">와사비과자</label>
            </li>
            <li><input type="radio" name="snack" value="붕어빵" id="붕어빵">
                <label for="붕어빵">붕어빵</label></li>
            <li><input type="radio" name="snack" value="쿠쉬쿠쉬" id="쿠쉬쿠쉬">
                <label for="쿠쉬쿠쉬">쿠쉬쿠쉬</label></li>
            <li><input type="radio" name="snack" value="초코하임" id="초코하임">
                <label for="초코하임">초코하임</label></li>
            <li><input type="radio" name="snack" value="몽쉘" id="몽쉘">
                <label for="몽쉘">몽쉘</label></li>
            <li><input type="radio" name="snack" value="커스터드" id="커스터드">
                <label for="커스터드">커스터드</label></li>
            <li><input type="radio" name="snack" value="쿠크다스" id="쿠크다스">
                <label for="쿠크다스">쿠크다스</label></li>
            <li><input type="radio" name="snack" value="초코파이" id="초코파이">
                <label for="초코파이">초코파이</label></li>
            <li><input type="radio" name="snack" value="꿀꽈배기" id="꿀꽈배기">
                <label for="꿀꽈배기">꿀꽈배기</label></li>
            <li><br></li>
            <li><input type="submit" value="투표하기"></li>
        </ul>
    </fieldset>
</form>
<form action="reset" method="get">
    <button type="submit">초기화</button>
</form>
</body>

</html>
