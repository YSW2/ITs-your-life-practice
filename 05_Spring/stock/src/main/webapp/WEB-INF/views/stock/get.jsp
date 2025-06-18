<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp" %>

<h1 class="page-header my-4"><i class="far fa-file-alt"></i> ${stock.stockName}</h1>

<div class="card p-3 d-flex justify-content-center gap-2">
    <div><b>종목 코드:</b> ${stock.stockCode}</div>
    <div><b>현재가:</b> ${stock.price}</div>
    <div>
        <b>등록일:</b> <fmt:formatDate pattern="yyyy-MM-dd" value="${stock.regDate}"/>
    </div>
    <div><b>설명:</b></div>
    <div>${stock.description}</div>
</div>


<div class="mt-4 d-flex flex-row gap-3">
    <a href="list" class="btn btn-secondary"><i class="fas fa-list"></i> 목록</a>
    <form action="/stock/buy" method="post" id="buyForm">
        <input type="hidden" name="no" value="${stock.no}"/>
        <input type="hidden" name="stockCode" value="${stock.stockCode}"/>
        <input type="hidden" name="stockName" value="${stock.stockName}"/>
        <input type="hidden" name="price" value="${stock.price}"/>
        <button type="submit" class="btn btn-success"><i class="fa-solid fa-cart-plus"></i> 매수하기</button>
    </form>
</div>

<%@include file="../layouts/footer.jsp" %>
