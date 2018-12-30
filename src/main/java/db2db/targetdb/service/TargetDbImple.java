package db2db.targetdb.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db2db.dto.domain.StartDbType;
import db2db.dto.domain.TargetDbType;
import db2db.startdb.repository.EnviromentVariableRepository;
import db2db.targetdb.domain.TargetDbTable;
import db2db.targetdb.repository.TargetDbRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TargetDbImple implements TargetDbService {

    @Autowired
    private EnviromentVariableRepository enviromentVariableRepository;

    @Autowired
    private TargetDbRepository smsRepository;

    @Override
    public boolean sendCheck() {
        return enviromentVariableRepository.findOneByEnvKey("SMS_ACTION_YN").getEnvKey().equals("ON");
    }

    //	보내는 날짜와 시간, 전송상태, 메세지 유형, 받는 전화번호, 보내는 전화번호, 메세지 내용
    @Override
    public Optional<TargetDbTable> logSaveSms(String eventLogMessage, String callBack, String phoneNumber) {
        try {
            Date sendDate = new Date();
            TargetDbTable logToSms = TargetDbTable.builder().
                    trSendDate(sendDate).
                    trSendStat(TargetDbType.SUCCESS.getStatus()).
                    trMsgType(StartDbType.SUCCESS.getMsgType()).
                    trPhone(phoneNumber).
                    trCallback(callBack).
                    trMsg(eventLogMessage).
                    build();
            TargetDbTable s = smsRepository.save(logToSms);
            return Optional.of(s);
        } catch (Exception e) {
            log.error("옳지 못한 접근입니다. 에러 내용 : {}", e.getMessage());
            return Optional.empty();
        }
    }
}
