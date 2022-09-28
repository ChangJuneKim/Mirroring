<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="idck" value=" checked"></c:set>
	<c:set var="svid" value="${cookie.ssafy_id.value}"></c:set>
</c:if>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>구해줘 홈즈</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="shortcut icon" href="${root}/images/favicon.png"
	type="image/x-icon" />
<link rel="stylesheet" href="${root}/style.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous" defer></script>
<script src="${root}/js/toggleHamberger.js" defer></script>
<script src="${root}/js/toggleNav.js" defer></script>
</head>
<body>

	<!-- 헤더 -->
	<header class="header">
		<h1>
			<a class="header__home-link" href="${ root }/user"> WhereIsMyHome
			</a>
		</h1>
		<a href="#" class="header__menu-btn"> <span class="bar"></span> <span
			class="bar"></span> <span class="bar"></span>
		</a>
		<nav class="header__nav">
			<ul>
				<li class="header__nav-item"><a href="#">공지사항</a></li>
				<li class="header__nav-item"><a href="#">아파트정보</a></li>
			</ul>
		</nav>
	</header>
	<main class="main__container">
	<div class="main__login-page">
		<h1>새로운 비밀번호 설정</h1>
		<div class="main__form">
			<form id="updatePwd-form" name="updatePwd-form" class="main__updatePwd-form"
				method="POST" action="">
				<input type="hidden" name="primId" value="${primId}"> <!-- ID값 넘겨주기 -->
				<input type="hidden" name="act" value="updatePwd">
				<input id="newPwd" name="newPwd"
					type="password" placeholder="새로운 비밀번호를 입력해주세요." /> 
				<input id="newPwd2" name="newPwd2"
					type="password" placeholder="다시 한번 입력해주세요." /> 
				
				<div class="text-danger mb-2">${msg}</div>
				<button id="updatePwd-btn" type="submit">새 비밀번호 설정</button>
			</form>
		</div>
	</div>
	</main>
	<!-- 푸터 -->
	<%@ include file="/include/footer.jsp"%>
	<!-- 푸터 끝-->
	<script type="text/javascript">
	const $updatePwdButton = document.querySelector("#updatePwd-btn");
	const upidate = () => {
		  // 문서에서 id로 input data 가져오기
		  const pwd1 = document.querySelector("#newPwd").value;
		  const pwd2 = document.querySelector("#newPwd2").value;

		  if (pwd1.trim().length == 0 || pwd2.trim().length == 0) {
		    alert("두 비밀번호 모두 입력해주세요.");
		    return;
		  } else {
			  let form = document.querySelector("#updatePwd-form");
	          form.setAttribute("action", "${root}/user");
	          form.submit();
		  }
	
		};

	$updatePwdButton.addEventListener("click", update);
	</script>
</body>
</html>
