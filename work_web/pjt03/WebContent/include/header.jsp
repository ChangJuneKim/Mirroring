<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<header class="header">
	<h1>
		<a class="header__home-link" href="${ root }"> WhereIsMyHome
		</a>
	</h1>
	<a href="#" class="header__menu-btn"> <span class="bar"></span> <span
		class="bar"></span> <span class="bar"></span>
	</a>
	<nav class="header__nav">
		<ul>
			<li class="header__nav-item"><a href="${root}/board?act=list">공지사항</a></li>
			<li class="header__nav-item"><a href="${root}/apart?act=mvapt2">아파트정보</a></li>
		</ul>

		<ul>
			<c:if test="${userinfo eq null}">
				<li class="header__nav-item"><a
					href="${ root }/user?act=mvjoin">회원가입</a></li>
				<li class="header__nav-item"><a
					href="${ root }/user?act=mvlogin">로그인</a></li>
			</c:if>
			<c:if test="${userinfo ne null}">
				<li class="header__nav-item"><span><strong>${userinfo.userName}</strong>
						(${userinfo.userId})님 안녕하세요.</span></li>
				<li class="header__nav-item" id="prefer"><a
					href="javascript:void(0);">관심지역</a></li>
				<li class="header__nav-item" id="logout"><a
					href="${root}/user?act=logout">로그아웃</a></li>
				<li class="header__nav-item" id="info"><a
					href="javascript:void(0);">회원정보</a></li>
			</c:if>
		</ul>
	</nav>

</header>