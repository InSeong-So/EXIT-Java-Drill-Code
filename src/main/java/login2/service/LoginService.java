package login2.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface LoginService {

	public ModelAndView signupSuccess(HttpServletRequest request);
}
