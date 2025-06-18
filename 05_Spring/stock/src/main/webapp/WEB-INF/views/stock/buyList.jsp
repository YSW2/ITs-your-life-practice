<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp" %>

<h1 class="page-header my-4"><i class="fa-solid fa-wallet"></i> 매수한 종목</h1>

<table class="table table-hover">
    <thead>
    <tr>
        <th>종목 코드</th>
        <th>종목 이름</th>
        <th>매수가</th>
        <th>매수일</th>
        <th>매도</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="buy" items="${list}">
        <tr>
            <td>${buy.stockCode}</td>
            <td>
                <a href="get?no=${buy.id}">${buy.stockName}</a>
            </td>
            <td>${buy.price}</td>
            <td>
                <fmt:formatDate pattern="yyyy-MM-dd" value="${buy.buyDate}"/>
            </td>
            <td>
                <form action="/stock/sell" method="post" id="buyForm">
                    <input type="hidden" name="no" value="${buy.id}"/>
                    <button type="submit" class="btn btn-danger"><i class="fa-solid fa-arrow-right-arrow-left"></i> 매도
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<%@include file="../layouts/footer.jsp" %>
