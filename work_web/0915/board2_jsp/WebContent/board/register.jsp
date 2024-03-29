<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%!
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
%>
<%
	// 1. data get
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("userid");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	System.out.println(userId + " " + subject + " " + content);

	// 2. logic
	Connection conn = null;
	PreparedStatement pstmt = null;
	int cnt = 0;
	try {
		conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC", "ssafy",
				"ssafy");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO board (user_id, subject, content, hit, register_time) \n");
		sql.append("VALUES (?, ?, ?, 0, NOW())");
		pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, userId);
		pstmt.setString(2, subject);
		pstmt.setString(3, content);
		cnt = pstmt.executeUpdate();

	} catch (SQLException e) {
		e.printStackTrace();

	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="/board2_jsp/assets/css/app.css" rel="stylesheet" />
<title>SSAFY</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">
					<mark class="sky">글쓰기 결과</mark>
				</h2>
			</div>
			<div class="col-lg-8 col-md-10 col-sm-12">
				<%
				if (cnt != 0) {
				%>
				<div class="card text-center bg-light">
					<h2 class="fw-bold text-primary pt-3">등록 완료!!!</h2>
					<div class="card-body">
						<p class="card-text">글작성이 완료되었습니다.</p>
						<button type="button" id="btn-list"
							class="btn btn-outline-primary">글목록 페이지 이동...</button>
					</div>
				</div>
				<%
				} else {
				%>
				<div class="card text-center bg-light">
					<h2 class="fw-bold text-danger pt-3">등록 실패T.T</h2>
					<div class="card-body">
						<p class="card-text">
							글작성에 문제가 있습니다. <br /> 잠시 후 시도해주세요.
						</p>
						<button type="button" id="btn-list" class="btn btn-outline-danger">
							글목록 페이지 이동...</button>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script>
		document.querySelector("#btn-list").addEventListener("click", function() {
			location.href = "/board2_jsp/board/list.jsp";
		});
	</script>
</body>
</html>
