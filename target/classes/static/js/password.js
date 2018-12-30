// 비밀번호 생성규칙 강화
// 1. 비밀번호는 영문(대소문자 구분 없음), 숫자, 특수문자 3가지 문자 조합으로 최소 8자리 이상 16자리 이하로 생성한다. = 완료
// 2. 사용자는 비밀번호 생성 시 각 호와 같은 추측 가능한 비밀번호를 사용하지 않도록 한다.
// 		ㄱ. 사용자 계정과 동일한 비밀번호 = 완료
//		ㄴ. 문자 또는 숫자만으로 구성된 비밀번호 = 완료
//		ㄷ. 사용자 계정, 생년월일, 주민등록번호, 전화번호를 포함한 비밀번호 = 전화번호 추가
//		ㄹ. 연속적인 반복(aaa,bbb 등)과 주기성 문자(abcd,1234 등) 및 키보드상의 연속된 배열(asdf,qwer 등)로 구성된 비밀번호  = 완료
//		ㅁ. 장비별로 동일한 비밀번호 = 질문해야하는 것
// 3. 비밀번호는 분기 1회 이상 변경을 원칙으로 한다. = 질문해야하는 것
//		ㄱ. 단, 특수권한 계정은 월 1회 이상 변경하여야 한다.
// 4. 사용자는 과거에 사용했던 비밀번호를 연속적으로 사용하지 않아야 한다. = 질문해야 하는것

$("#bt").on("click", function() {
	var data = {
		"userId" : $("#userId").val(),
		"userName" : $("#userName").val(),
		"userBirthday" : $("#userBirthday").val(),
		"userPhoneNumb" : $("#userPhoneNumb").val(),
		"userPassword" : $("#userPassword").val(),
		"userCode" : $("#userCode").val()
	};

	passwordCharacterCheck(data);

});

function passwordCharacterCheck(data, checkLength) {

	var bagicTextRegExp = new RegExp(
			"^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[?!@#$%^&*-]).{8,16}$");
	var continuousText = [ "0123456789", "abcdefghijklmnopqrstuvwxyz",
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ", "qwertyuiopasdfghjklzxcvbnm",
			"QWERTYUIOPASDFGHJKLZXCVBNM" ];
	var continuousTextRegExp = "";
	var sameTextRegExp = new RegExp("(.)\\1\\1");

	var phoneNumbData = data.userPhoneNumb.split("-");

	var userInformationTextRegExp = new RegExp("" + data.userId + "|"
			+ data.userName + "|" + data.userBirthday + "|" + phoneNumbData[1]
			+ "|" + phoneNumbData[2] + "");

	if (!checkLength) {
		checkLength = 3; // 연속되는 글자수를 지정하지 않으면 3으로 지정
	}

	if (bagicTextRegExp.test(data.userPassword)) {
		for (var i = 0; i < continuousText.length; i++) {
			var compareOne = continuousText[i];
			var compareTwo = continuousText[i] + continuousText[i];
			for (var j = 0; j < compareOne.length; j++) {
				var startIndex = compareOne.substr(j, 1); // 0
				var endIndex = compareTwo.substr(j, checkLength); // 012
				continuousTextRegExp += "[" + startIndex + "]{" + checkLength
						+ ",}|"; // [0]{3,}|012|[1]{3,}|123|...
				continuousTextRegExp += endIndex + "|";
			}
		}
		continuousTextRegExp = new RegExp(continuousTextRegExp
				.replace(/.$/, "")); // 마지막의 글자를 하나 지우고 정규식으로 선언

		if (continuousTextRegExp.test(data.userPassword)
				|| sameTextRegExp.test(data.userPassword)
				|| userInformationTextRegExp.test(data.userPassword)) {
			console.log("실패" + " _____________ " + data.userPassword);
			return false;
		} else {
			console.log("성공" + " _____________ " + data.userPassword);
			return true;
		}

	} else {
		alert("비밀번호는 영문(대소문자 구분 없음), 숫자, 특수문자 3가지 문자를 조합하여 최소 8자리 이상 16자리 이하로 생성해주세요.");
		$("#userPassword").val("");
		return false;
	}
}