package login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import login.domain.UserTable;

public interface LoginRepository extends JpaRepository<UserTable, String>{
	
	public UserTable findOneByCode(String userCode);
}
