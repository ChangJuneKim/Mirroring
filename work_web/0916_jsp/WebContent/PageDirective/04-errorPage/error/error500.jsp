<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page isErrorPage="true"%>
<!-- 에러 페이지(true여야 exception을 사용할 수 있다) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>오류가 발생했습니다.</h1>
	<p>
		에러 타입 :
		<%=exception.getClass().getName()%></p>
	<p>
		에러 메세지 :
		<%=exception.getMessage()%></p>
</body>
</html>