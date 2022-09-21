<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	<h1>인사관리 - 상세조회</h1>
	<c:if test="${ !empty person }">
		<table>
			<tr>
				<th>사원ID</th>
				<td>${ person.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${ person.name }</td>
			</tr>
			<tr>
				<th>부서명</th>
				<td>${ person.department_name }</td>
			</tr>
			<tr>
				<th>봉급</th>
				<td>${ person.pay }</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${ empty person }">
		<p>선택한 제품 정보가 없습니다</p>
	</c:if>
	<a href="${ root }/main?action=index">메인페이지로</a>
	<a href="${ root }/main?action=delete&personId=${ person.id }">삭제</a>

	
	<%@ include file="/include/footer.jsp" %>