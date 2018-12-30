package db2db.startdb.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import db2db.startdb.domain.StartDbTable;

public interface StartDbRepository extends JpaRepository<StartDbTable, Long> {

	public List<StartDbTable> findByOccurTimeBetween(Timestamp startTime, Timestamp endTime);
}
