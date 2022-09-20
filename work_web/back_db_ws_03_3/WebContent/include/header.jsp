<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	h1#title{
		text-align : center;
	}
	
	#user-info{
		text-align: right;
	}
</style>

<h1 id="title">SSAFY 도서 관리</h1>
<div id="user-info">
	<c:choose>
		<c:when test="${ !empty loginUser }">
			<div>
				${ loginUser.name }님 반갑습니다. <a href="main?action=logout">로그아웃</a>
			</div>
		</c:when>
		<c:otherwise>
			<form method="post" action="main">
				<input type="hidden" name="action" value="login">
				<input type="text" name="id" placeholder="아이디">
				<input type="password" name="pass" placeholder="비밀번호">
				<input type="submit" value="로그인">
			</form>
		</c:otherwise>
	</c:choose>
</div>
<hr>
<script>
let msg = "${msg}";
if(msg){
	alert(msg);
}
</script>
