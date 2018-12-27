package login.service;

import login.domain.UserTable;

public interface LoginService {

	public boolean remainingCodeChack(String requestCode, UserTable userInformation);
}
