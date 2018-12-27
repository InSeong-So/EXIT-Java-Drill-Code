package login.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import login.domain.UserTable;
import login.repository.LoginRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LoginRegistration {

	@Autowired
	private LoginRepository loginRepository;
	
	@Builder
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class RegisterReqeust {
		private String id;
		private String name;
		@Nullable
		private String code;
		private String birthday;
		private String phone_num;
		private String password;

		public static UserTable PasswordEntityBuilder(RegisterReqeust r) {

			return UserTable.builder().id(r.getId()).name(r.getName()).code(r.getCode()).point(0L)
					.birthday(r.getBirthday()).phoneNumb(r.getPhone_num()).password(r.getPassword()).build();
		}
	}

	@Builder
	@Setter
	@Getter
	@AllArgsConstructor
	public static class RegisterResponse {
		private String msg;

	}
	
	public RegisterResponse registrationFunction(RegisterReqeust request) {
		if (loginRepository.findById(request.getId()).isPresent()) {
			return new RegisterResponse("등록 실패, 이미 존재하는 아이디입니다.");
		}

		UserTable passwordEntity = RegisterReqeust.PasswordEntityBuilder(request);

		loginRepository.save(passwordEntity);

		return new RegisterResponse("등록 성공");
	}
}
