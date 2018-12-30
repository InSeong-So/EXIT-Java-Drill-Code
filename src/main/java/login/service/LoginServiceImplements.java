package login.service;

import org.springframework.beans.factory.annotation.Autowired;

import login.domain.UserTable;
import login.repository.LoginRepository;

public class LoginServiceImplements implements LoginService{

	@Autowired
	private LoginRepository loginRepository;

	public boolean remainingCodeChack(String requestCode, UserTable userInformation) {
		if (requestCode != null) {
			if (userInformation != null) {
				if (!userInformation.getCode().isEmpty()) {
					userInformation.setPoint(userInformation.getPoint() + 1);
					loginRepository.save(userInformation);
				}
			}
		}

		return true;
	}
}
