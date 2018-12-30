package db2db.targetdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import db2db.targetdb.domain.TargetDbTable;

public interface TargetDbRepository extends JpaRepository<TargetDbTable, Long> {

}
