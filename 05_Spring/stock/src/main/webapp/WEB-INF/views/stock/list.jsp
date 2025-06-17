<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp" %>

<h1 class="page-header my-4"><i class="fa-solid fa-chart-simple"></i> 주식 목록</h1>

<table class="table table-hover">
    <thead>
    <tr>
        <th style="width: 60px">No</th>
        <th>종목코드</th>
        <th>종목이름(링크)</th>
        <th>가격</th>
        <th>등록일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="board" items="${list}">
        <tr>
            <td>${board.no}</td>
            <td>${board.stockCode}</td>
            <td>
                <a href="get?no=${board.no}">${board.stockName}</a>
            </td>
            <td>${board.price}</td>
            <td>
                <fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="text-end">
    <a href="create" class="btn btn-primary">
        <i class="far fa-edit"></i>
        새 종목 추가
    </a>
</div>

<%@include file="../layouts/footer.jsp" %>
