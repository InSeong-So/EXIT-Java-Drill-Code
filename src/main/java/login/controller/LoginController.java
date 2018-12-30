package login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import login.util.LoginRegistration;
import login.util.LoginRegistration.RegisterReqeust;

@Controller
public class LoginController {

	private LoginRegistration loginResitration;

	@RequestMapping(value = "/")
	public String homePage() {
		return "passwordForm.html";
	}

	@PostMapping("/registration")
	@ResponseBody
	public void doRegistration(@RequestBody RegisterReqeust request) {
		loginResitration.registrationFunction(request);
	}

	@RequestMapping("/success")
	public String doCode(HttpServletRequest request, Model model) {
		return "home.html";
	}

}