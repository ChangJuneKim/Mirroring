<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
		<h1>인사 등록 성공 페이지</h1>
		<p>${ cnt }명 등록 성공</p>
		<a href="${root}/main?action=list">인사 목록 조회</a>
	
	</div>

<%@ include file="/include/footer.jsp" %>