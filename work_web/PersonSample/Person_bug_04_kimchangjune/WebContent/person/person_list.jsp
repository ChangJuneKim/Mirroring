<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">

		<h1>목록 페이지 입니다.</h1>

		<table>
			<tr>
				<td>ID</td>
				<td>이름</td>
				<td>부서명</td>
				<td>봉급</td>
			</tr>
			<c:if test="${ !empty personList }">
				<c:forEach var="person" items="${ personList }">
					<tr>
						<td><a
								href="${ root }/main?action=detail&personId=${person.id}">${ person.id }</a></td>
						<td>${ person.name }</td>
						<td>${ person.department_name }</td>
						<td>${ person.pay }</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${ empty personList}">
				<p>등록된 사람이 없습니다.</p>
			</c:if>
		</table>
		<a href="${ root }/main?action=regist_form">추가 등록</a>
	</div>

	<%@ include file="/include/footer.jsp"%>