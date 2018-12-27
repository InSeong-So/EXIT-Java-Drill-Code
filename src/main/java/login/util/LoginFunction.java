package login.util;

import java.util.Random;

public class LoginFunction {

	public StringBuffer makeRemainingCode() {
		String beforeConvertCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer code = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			code.append(beforeConvertCode.charAt(random.nextInt(beforeConvertCode.length())));
		}

		return code;
	}

}
