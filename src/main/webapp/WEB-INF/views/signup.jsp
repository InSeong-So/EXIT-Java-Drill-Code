<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/success" method="post">
		<input type="text" name="id" placeholder="아이디를 입력하세요." /><br> <input
			type="password" name="password" placeholder="비밀번호를 입력하세요." /><br>
		<input type="text" name="name" placeholder="이름을 입력하세요." /><br> <input
			type="text" name="code" placeholder="추천인 코드를 입력하세요." /><br> <input
			type="submit" value="완료" />
	</form>
	<button onclick="location='/'">돌아가기</button>
</body>
<script type="text/javascript">
</script>
</html>