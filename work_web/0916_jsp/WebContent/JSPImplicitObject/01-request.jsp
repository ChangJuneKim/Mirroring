<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		클라이언트 IP =
		<%=request.getRemoteAddr()%></div>
	<div>
		요청정보길이 =
		<%=request.getContentLength()%></div>
	<div>
		요청정보 인코딩 =
		<%=request.getCharacterEncoding()%></div>
	<div>
		요청정보 컨텐츠타입 =
		<%=request.getContentType()%></div>
	<div>
		요청정보 프로토콜 =
		<%=request.getProtocol()%></div>
	<div>
		요청정보 전송방식 =
		<%=request.getMethod()%></div>
	<div>
		요청 URI =
		<%=request.getRequestURI()%></div>
	<div>
		컨텍스트 경로 =
		<%=request.getContextPath()%></div>
	<div>
		서버 이름 =
		<%=request.getServerName()%></div>
	<div>
		서버 포트 =
		<%=request.getServerPort()%></div>
</body>
</html>