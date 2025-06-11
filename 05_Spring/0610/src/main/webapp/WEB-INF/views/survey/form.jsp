<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>나만의 설문 유도 페이지 만들기</h1>
<form method="post">
    <div>
        <label for="name">이름: </label>
        <input type="text" name="name">
    </div>

    <div>
        <label for="link">설문 링크: </label>
        <input type="text" name="link">
    </div>

    <div>
        <label for="ment">설문 참여를 유도하는 한 마디: </label>
        <input type="text" name="ment" placeholder="예: 궁금하면 꼭 참여해줘!">
    </div>

    <input type="submit" value="공유 페이지 생성">
</form>
</body>
</html>
