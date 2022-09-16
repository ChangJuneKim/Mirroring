<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	String userId = request.getParameter("userId");
	String pwd = request.getParameter("pwd");

	if ("ssafy".equals(userId) && "1234".equals(pwd)) {
		// forward
		//RequestDispatcher disp = request.getRequestDispatcher("./03-success.jsp");
		//disp.forward(request, response);
		pageContext.forward("./03-success.jsp");
		
		// sendRedirect
		//response.sendRedirect(request.getContextPath() + "/JSPImplicitObject/03-success.jsp");
	}
	else {
%>
<html>
<head>
	<title>로그인 실패</title>
</head>
<body>
	<h1>로그인 실패했습니다.</h1>
</body>
</html>
<%
	}
%>