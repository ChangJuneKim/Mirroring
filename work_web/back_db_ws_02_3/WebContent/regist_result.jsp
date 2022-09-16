<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- dto 참조하기 위해서 import  -->
<%@ page import="com.ssafy.ws.step3.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
}

th:nth-child(1) {
	width: 100px;
}
</style>
</head>
<body>
	<h1>도서 등록 결과</h1>
	<%
		// request 영역에 book이라는 이름으로 등록된 자료를 가져온다.
		// request 영역에 접근하기 위해 request 기본 객체를 활용한다.
		Object bookObj = request.getAttribute("book");
		if (bookObj != null && bookObj instanceof Book) {
			Book book = (Book) bookObj;
	%>

	<h2>등록 도서 정보</h2>
	<table>
		<thead>
			<tr>
				<th>항목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>도서번호</td>
				<td><%=book.getIsbn()%></td>
			</tr>
			<tr>
				<td>도서명</td>
				<td><%=book.getTitle()%></td>
			</tr>
			<tr>
				<td>저자</td>
				<td><%=book.getAuthor()%></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><%=book.getPrice()%></td>
			</tr>
			<tr>
				<td>설명</td>
				<td><%=book.getDesc()%></td>
			</tr>
		</tbody>
	</table>
	<%
		} else {
	%>
	<p>등록된 도서가 없습니다</p>
	<%
		}
	%>
	<a href="regist.jsp">추가 등록</a>
</body>
</html>