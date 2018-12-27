package login.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserTable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	private Long no;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "birthday")
	private String birthday;

	@Column(name = "phone_numb")
	private String phoneNumb;

	@Column(name = "password")
	private String password;

	@Column(name = "code")
	private String code;

	@Column(name = "point")
	private Long point;
}
