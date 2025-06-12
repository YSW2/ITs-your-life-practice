<%--
  Created by IntelliJ IDEA.
  User: 양성욱
  Date: 25. 6. 11.
  Time: 오후 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>설문 결과 이미지 업로드</h1>
<p>캡처된 이미지로 GPT에게 결과 요약을 요청해보세요!</p>
<form action="/survey/upload" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
    <label for="image">이미지 파일: </label>
    <input type="file" name="file">
    <input type="hidden" value="${id}" name="id">
    <br>
    <input type="submit" value="업로드 완료">
</form>
</body>
</html>
