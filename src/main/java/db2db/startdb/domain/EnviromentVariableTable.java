package db2db.startdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MNG_ENV_EXTEND")
public class EnviromentVariableTable {
	@Id
	@Column(name = "ENV_KEY", length = 100)
	private String envKey;

	@Column(name = "ENV_VALUE", length = 100)
	private String envValue;

}
