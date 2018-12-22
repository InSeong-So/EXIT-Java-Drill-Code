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
	<h1>메인화면</h1>
	<form>
		<input type="text" id="userId" placeholder="아이디를 입력하세요." /><br>
		<input type="password" id="userPassword" placeholder="비밀번호를 입력하세요." /><br>
		<input type="button" id="loginButton" value="로그인" />
	</form>
	<button onclick="location='signup'">회원가입</button>
	<button>코드발급</button>
</body>
<script type="text/javascript">
 $("#loginButton").on("click", function(){
	 var data = {}
	 data["userId"] = $("#userId").val();
	 data["userPassword"] = $("#userPassword").val();
	 
	 $.ajax({
		url: "/login",
		dataType: "json",
		contentType:'application/json',
		type:"POST",
		data:JSON.stringify(data)
	 }).done(function(data){
		console.log(data); 
	 });
 });
</script>
</html>