package login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import login.domain.LoginDAO;

@Controller
@SessionAttributes("sessionDrill")
public class LoginController {

	@Autowired
	private LoginDAO loginDAO;

	@RequestMapping("/")
	public String mainPage() {
		return "main";
	}

	@RequestMapping(value = "/session", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sessionCheck(HttpSession session) {
		Map<String, Object> sessionResult = new HashMap<String, Object>();

		if (sessionResult.put("user", session.getAttribute("user")) != null) {
			sessionResult.put("user", session.getAttribute("user"));
		}
		return sessionResult;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(@RequestBody Map<String, Object> params, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if (loginDAO.idConfirm(params)) {
				session.setAttribute("user", params);
			}
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			return resultMap;
		}
		resultMap.put("message", "회원 정보입니다.");
		return resultMap;
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("/signup")
	public String signupPage() {
		return "signup";
	}

	@RequestMapping("/success")
	public String successPage(HttpServletRequest request) {
		loginDAO.insertUser(request);
		return "main";
	}
}
