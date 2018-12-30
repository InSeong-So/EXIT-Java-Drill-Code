package db2db.startdb.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import db2db.startdb.domain.EnviromentVariableTable;
import db2db.startdb.domain.StartDbTable;
import db2db.startdb.repository.EnviromentVariableRepository;
import db2db.startdb.repository.StartDbRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StartDbImple implements StartDbService {

    private static final int SMS_MAX_SIZE = 60;
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private static final Timestamp DEFAULT_START_TIME = new Timestamp(System.currentTimeMillis());
    private static final Timestamp DEFAULT_END_TIME = new Timestamp(System.currentTimeMillis());

    @Autowired
    private EnviromentVariableRepository enviromentVariableRepository;

    @Autowired
    private StartDbRepository logRepository;


    @Override
    public List<String> phoneNumberList() {
        EnviromentVariableTable phoneNumberVariable = enviromentVariableRepository.findOneByEnvKey("SMS_HP_NUMBERS");
        List<String> phoneNumberList = new ArrayList();
//        if (phoneNumberVariable.getEnvValue() == null || phoneNumberVariable.getEnvValue().isEmpty()) {
//            phoneNumberList.add("000-0000-0000");
//            phoneNumberList.add("111-1111-1111");
//            phoneNumberList.add("222-2222-2222");
//            log.info("전화번호를 입력해주세요. 현재 저장되어 있는 수신자 번호가 없습니다.");
////			return null;
//            return phoneNumberList;
//        } else {
//            String[] numberList = phoneNumberVariable.getEnvValue().split(";");
//            for (String phoneNumber : numberList) {
//                phoneNumberList.add(phoneNumber);
//            }
//            return phoneNumberList;
//        }

        if (phoneNumberVariable.getEnvValue() == null || phoneNumberVariable.getEnvValue().isEmpty()) {
            return new ArrayList<String>();
        } else {
            String[] numberList = phoneNumberVariable.getEnvValue().split(";");

            for (String phoneNumber : numberList) {
                // TODO phone number validation

                phoneNumberList.add(phoneNumber);
            }
            return phoneNumberList;
        }
    }

    @Override
    public List<StartDbTable> startEndTimeLog(Timestamp startAt, Timestamp endAt) {

//				현재, ADCsmart의 로그가 쌓이지 않으므로 최근 기록을 고정적으로 불러오게끔 설정했다.				
//				Date parseStartTime = format.parse(new Timestamp(System.currentTimeMillis() - 10 * 1000L).toString());
//				Date parseEndTime = format.parse(new Timestamp(System.currentTimeMillis() - 60 * 1000L).toString());
//				Timestamp startTime = new Timestamp(parseStartTime.getTime());
//				Timestamp endTime = new Timestamp(parseEndTime.getTime());
//
//        List<AlarmLog> logList = logRepository.findByOccurTimeBetween(startAt, endAt);
//        if (logList.isEmpty() || logList == null) {
//            log.info("해당 시간에 대한 로그가 없습니다.");
//            return null;
//        }
        return logRepository.findByOccurTimeBetween(startAt, endAt);

    }

    @Override
    public String eventLogParsing(String eventLog) {
        // UTF-8? UTF-16

        if (eventLog.length() > SMS_MAX_SIZE) {

            log.info("저장한 데이터2 : {}", eventLog.substring(0, SMS_MAX_SIZE / 2));
            return eventLog.substring(0, SMS_MAX_SIZE / 2);
        } else if (eventLog.length() < SMS_MAX_SIZE) {
            log.info("저장한 데이터 : {}", eventLog);
            return eventLog;
        } else {
            log.info("옳지 못한 메세지입니다. 다시 입력해주세요.");
            return null;
        }
    }
}
