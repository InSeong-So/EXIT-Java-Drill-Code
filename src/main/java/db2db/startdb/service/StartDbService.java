package db2db.startdb.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Repository;

import db2db.startdb.domain.StartDbTable;

@Repository
public interface StartDbService {

	public List<String> phoneNumberList();

	public List<StartDbTable> startEndTimeLog(Timestamp startAt, Timestamp endAt);

	public String eventLogParsing(String eventLog);
}

