<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!-- dto 참조하기 위해서 import  -->
<%@ page import="com.ssafy.ws.step3.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%@ include file="./include/header.jsp"%>
	<h1>도서 등록 결과</h1>
	<%-- <%
		// request 영역에 book이라는 이름으로 등록된 자료를 가져온다.
		// request 영역에 접근하기 위해 request 기본 객체를 활용한다.
		Object bookObj = request.getAttribute("book");
		if (bookObj != null && bookObj instanceof Book) {
			Book book = (Book) bookObj;
	%> --%>

	<!-- requestScope.book 이 맞지만 자주 쓰는거라 생략하는것을 허용한다~  -->
	<c:if test="${ !empty book}">
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
					<%-- <td><%=book.getIsbn()%></td> --%>
					<td>${ book.isbn}</td>
				</tr>
				<tr>
					<td>도서명</td>
					<%-- <td><%=book.getTitle()%></td> --%>
					<td>${book.title}</td>
				</tr>
				<tr>
					<td>저자</td>
					<%-- <td><%=book.getAuthor()%></td> --%>
					<td>${book.author}</td>
				</tr>
				<tr>
					<td>가격</td>
					<%-- <td><%=book.getPrice()%></td> --%>
					<td>${book.price}</td>
				</tr>
				<tr>
					<td>설명</td>
					<%-- <td><%=book.getDesc()%></td> --%>
					<td>${book.desc}</td>
				</tr>
			</tbody>
		</table>
	</c:if>
	<%-- <%
		} else {
	%> --%>
	<!-- else가 없다 -->
	<c:if test="${empty book}">
		<p>등록된 도서가 없습니다</p>
	</c:if>
	<%-- <%
		}
	%> --%>
	<a href="regist.jsp">추가 등록</a>
</body>
</html>