<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>구해줘 홈즈</title>
 
<link rel="shortcut icon" href="../images/favicon.png"
	type="image/x-icon" />
<link rel="stylesheet" href="../style.css" />

<script src="../js/toggleNav.js" defer></script>
</head>
<body>
	<!-- 헤더 -->
	<header class="header">
		<h1>
			<a class="header__home-link"  href="${ root }/user"> WhereIsMyHome </a>
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
	<div class="main__register-page">
		<h1 id="register">회원가입</h1>
		<div class="main__form">
			<form id="form-join" method="POST" action="" 
				class="main__register-form">
				<input type="hidden" name="act" value="join"> 
				<input id="username" name="username" type="text" placeholder="이름" /> 
				<input id="userid" name="userid" type="text" placeholder="아이디" />
				<div id="idcheck-result" style="font-size : 8px; text-align : initial; translate : 2px -16px"></div> 
				<input id="password" name="password" type="password" placeholder="비밀번호" />
				<input 
					id="passwordCheck" 
					name="passwordCheck" 
					type="password"
					placeholder="비밀번호확인" 
				/> 
				<input 
					id="address" 
					name="address"
					type="text" 
					placeholder="주소" 
				/> 
				<input 
					id="phone" 
					name="phone"
					type="text" 
					placeholder="전화번호" 
				/> 
				<div class="mb-3">
					<div class="input-group">
						<input type="text" class="form-control" id="emailid"
							name="emailid" placeholder="이메일아이디" /> <span
							class="input-group-text">@</span> <select class="form-select"
							id="emaildomain" name="emaildomain" aria-label="이메일 도메인 선택">
							<option selected>선택</option>
							<option value="ssafy.com">싸피</option>
							<option value="google.com">구글</option>
							<option value="naver.com">네이버</option>
							<option value="kakao.com">카카오</option>
						</select>
					</div>
				</div>
				<div style="display: flex">
					<button id="register-btn" type="button" style="margin-right: 6px">회원가입</button>
					<button type="reset">초기화</button>
				</div>
				<p>
					계정이 있습니다.<u><a href="${ root }/user?act=mvlogin">로그인</a></u>
				</p>
			</form>
		</div>
	</div>
	</main>
	 <!-- 푸터 -->
	<%@ include file="/include/footer.jsp"%>
	<!-- 푸터 끝-->
	<script>
	const $registerButton = document.querySelector('#register-btn');

	const register = () => {
	  // 문서에서 id 로 input data 가져오기
	  const id = document.querySelector('#userid').value;
	  const password = document.querySelector('#password').value;
	  const name = document.querySelector('#username').value;
	  const address = document.querySelector('#address').value;
	  const phone = document.querySelector('#phone').value;
	  const emailId = document.querySelector('#emailid').value;
	  const emailDomain = document.querySelector('#emaildomain').value;

	  // 입력값 검증
	  if (
	    id.trim().length === 0 ||
	    password.trim().length === 0 ||
	    name.trim().length === 0 ||
	    address.trim().length === 0 ||
	    phone.trim().length === 0 ||
	    emailId.trim().length === 0 ||
	    emailDomain.trim().length === 0 
	  ) {
	    alert('빈칸이 없도록 입력해주세요.');
	    return;
	  } else {
		  let form = document.querySelector("#form-join");
	      form.setAttribute("action", "${root}/user");
	      form.submit();
	  }
	};

	$registerButton.addEventListener('click', register);
	
	let isUseId = false;
	document.querySelector("#userid").addEventListener("keyup", function () {
		 let userid = this.value;
		 let resultDiv = document.querySelector("#idcheck-result");
		 if(userid.length < 5 || userid.length > 16) {
			 resultDiv.style.color = 'black';
			 resultDiv.textContent = "아이디는 5자 이상 16자 이하 입니다.";
			 isUseId = false;
		 } else {
			fetch("${root}/user?act=idcheck&userid=" + userid)
				.then(response => response.text())
				.then(data => {
					console.log(data);
	  			 if(data == 0) {
	  				resultDiv.style.color = 'mediumspringgreen';
	  		       resultDiv.textContent = userid + "는 사용할 수 있습니다.";
	  		       isUseId = true;
	  			 } else {
	  				resultDiv.style.color = 'red';
	    		       resultDiv.textContent = userid + "는 사용할 수 없습니다.";
	    		       isUseId = false;
	  			 }
				});
		 }
	});
	</script>
</body>
</html>
