<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
	<div>
		<h1 id="headFont"></h1>
		<form id="form">
			<input type="text" id="userId" placeholder="아이디를 입력하세요." />
			<br>
			<input type="password" id="userPassword" placeholder="비밀번호를 입력하세요." />
			<br>
			<input type="button" id="loginButton" value="로그인" />
			<br>
			<input type="button" onclick="location='signup'" value="회원가입" />
		</form>
		<button id="code" style="display: none">코드발급</button>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({url : "/session", dataType : "json", contentType : 'application/json', type : "POST"}).done(function(data) {
			if (data.user != null) {
				alert("환영합니다.");
			} else {
				$("#headFont").text("메인화면");
// 				$("#loginButton").on("click", function() {
// 					var data = {}
// 					data["userId"] = $("#userId").val();
// 					data["userPassword"] = $("#userPassword").val();

// 					$.ajax({
// 						url : "/login",
// 						dataType : "json",
// 						contentType : 'application/json',
// 						type : "POST",
// 						data : JSON.stringify(data)
// 					}).done(function(data) {
// 						window.location.reload();
// 						$("#headFont").text("환영합니다!");
// 						$("#form").css("display", "none");
// 						$("#code").css("display", "block");
// 					});
// 				});
			}
		});

	});
</script>
</html>