<!-- 인코딩 적용 우선순위
1. pageEncoding
2. contentType
3. 모두 해당 되지 않을 경우는 ISO-8859-1 캐릭터 셋을 사용
결론 : pageEncoding을 가급적이면 사용하지 않음
 -->

<%@ page contentType="text/html; charset=euc-kr"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>인코딩 적용 순서</title>
</head>
<body>
<p>동해물과...</p>
<p>abcde...</p>
<p>👍👍</p>
<p>★</p>
</body>
</html>