<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>구해줘 홈즈</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link rel="stylesheet" href="../style.css" />
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous" defer></script>
<script src="./js/toggleNav.js" defer></script>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="/include/header.jsp"%>
	<div class="row justify-content-center"  style="height: 777px; margin-right : 0;">
		<div class="col-lg-8 col-md-10 col-sm-12">
			<h2 class="my-3 py-3 shadow-sm bg-light text-center">
				<mark class="sky">글쓰기</mark>
			</h2>
		</div>
		<div class="col-lg-8 col-md-10 col-sm-12">
			<form id="form-register" method="POST" action="">
				<input type="hidden" name="act" value="write">
				<div class="mb-3">
					<label for="subject" class="form-label">제목 : </label> <input
						type="text" class="form-control" id="subject" name="subject"
						placeholder="제목..." />
				</div>
				<div class="mb-3">
					<label for="content" class="form-label">내용 : </label>
					<textarea class="form-control" id="content" name="content" rows="7" style="height: 370px; resize : none;"></textarea>
				</div>
				<div class="col-auto text-center">
					<button type="button" id="btn-register"
						class="btn btn-outline-primary mb-3">글작성</button>
					<button type="button" id="btn-list"
						class="btn btn-outline-danger mb-3">목록으로이동...</button>
				</div>
			</form>
		</div>
	</div>
	<script>
      document.querySelector("#btn-register").addEventListener("click", function () {
        if (!document.querySelector("#subject").value) {
          alert("제목 입력!!");
          return;
        } else if (!document.querySelector("#content").value) {
          alert("내용 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-register");
          form.setAttribute("action", "${root}/board");
          form.submit();
        }
      });
      
      document.querySelector("#btn-list").addEventListener("click", function () {
    	if(confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {

   	    }
      });
    </script>

	<!-- 푸터 -->
	<%@ include file="/include/footer.jsp"%>
	<!-- 푸터 끝-->
</body>
</html>
