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
<h1>${survey.getName()}님의 설문 결과</h1>
<p><b>한마디: </b>${survey.getMent()}</p>
<p><b>설문 링크: </b><a href="${survey.getLink()}">${survey.getLink()}</a></p>
<h3>업로드한 설문 결과 이미지</h3>
<img src="/resources/uploads/${uploadedImage}">
</body>
</html>
