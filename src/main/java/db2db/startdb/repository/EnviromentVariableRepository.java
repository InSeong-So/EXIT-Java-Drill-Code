package db2db.startdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import db2db.startdb.domain.EnviromentVariableTable;

public interface EnviromentVariableRepository extends JpaRepository<EnviromentVariableTable, String> {

	public EnviromentVariableTable findOneByEnvKey(String envKey);
}
