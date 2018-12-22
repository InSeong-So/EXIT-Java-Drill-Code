package login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import login.domain.LoginDAO;

@Controller
public class LoginController {

	@Autowired
	private LoginDAO loginDAO;
	
	@RequestMapping("/")
	public String mainPage() {
		return "main";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userInfo(@RequestBody Map<String, Object> params){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			System.out.println(loginDAO.idConfirm(params));
		} catch (Exception e) {
			resultMap.put("message", e.getMessage());
			return resultMap;
		}
		resultMap.put("message", "회원 정보입니다.");
		return resultMap;
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
