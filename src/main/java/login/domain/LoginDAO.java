package login.domain;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
public class LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 로그인
	public boolean idConfirm(Map<String, Object> params) {
		String query = "SELECT * FROM login2 WHERE id='" + params.get("userId") + "'AND password='" + params.get("userPassword") + "'";
		System.out.println(query);
		if(jdbcTemplate.queryForList(query).isEmpty()) {
			return true;
		}
		return false;
	}

	// 회원가입
	public int insertUser(HttpServletRequest request) {
		String query = "INSERT INTO login2 (id, password, name, code) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(query, request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("code"));
	}

}
