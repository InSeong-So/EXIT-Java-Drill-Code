package db2db.targetdb.service;

import org.springframework.stereotype.Repository;

import db2db.targetdb.domain.TargetDbTable;

import java.util.Optional;

@Repository
public interface TargetDbService {
	
	public boolean sendCheck();

	public Optional<TargetDbTable> logSaveSms(String eventLogMessage, String callBack, String phoneNumberList);

}
