package login2.domain;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 로그
	public boolean idConfirm(Map<String, Object> params) {
		String query = "SELECT * FROM user WHERE id='" + params.get("userId") + "'AND password='" + params.get("userPassword") + "'";
		System.out.println(query);
		if(jdbcTemplate.queryForList(query).isEmpty()) {
			System.out.println(jdbcTemplate.queryForList(query));
			return false;
		}
		return true;
	}

	// 회원가입
	public int insertUser(HttpServletRequest request) {
		String query = "INSERT INTO user (id, password, name, code) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(query, request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("code"));
	}

}
