<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구해줘 홈즈</title>
<%-- 부트스트랩 사용을 위한 코드 --%>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<%-- request 객체에 msg가 들어있을 때 해당 내용 알림창 띄우기 --%>
<script>
	<c:if test="${!empty msg}">
		alert("${msg}");
	</c:if>
</script>
<link rel="shortcut icon" href="./images/favicon.png"
	type="image/x-icon" />
<link rel="stylesheet" href="${ root }/style.css" />
<script src="${ root }/js/toggleHamberger.js" defer></script>
<script src="${ root }/js/modal.js" defer></script>
<script src="${ root }/js/index.js" defer></script>
<script src="${ root }/js/toggleNav.js" defer></script>
</head>
<body>
	<%@ include file="/include/header.jsp"%>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4" style="height: 81vh">
		<h1 style="font-size : 48px;">오류가 발생했습니다.</h1>
		<div>
			<a href="${root}" style="font-size : 32px; color : blue; text-decoration : underline;">메인 화면으로 이동</a>
		</div>
	</div>
	<%-- --%>
	<%@ include file="/include/footer.jsp"%>