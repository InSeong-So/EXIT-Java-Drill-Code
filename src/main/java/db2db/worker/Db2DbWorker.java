package db2db.worker;

import java.awt.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import db2db.dto.domain.EventDTO;
import db2db.startdb.domain.StartDbTable;
import db2db.startdb.service.StartDbService;
import db2db.targetdb.service.TargetDbService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Db2DbWorker {

    @Autowired
    private StartDbService logService;

    @Autowired
    private TargetDbService smsService;

    private static final Timestamp DEFAULT_START_TIME = new Timestamp(System.currentTimeMillis());
    private static final Timestamp DEFAULT_END_TIME = new Timestamp(System.currentTimeMillis());

    private String phoneCallBack = "02-9999-9999";

    private Queue<EventDTO> eventQueue = new ConcurrentLinkedQueue<>();

    private List<String> phoneNumberList;

    private List<String> eventDataList;

//	private List<Long> actionCheckList = new ArrayList<Long>();;

    private boolean smsSavecheck = false;

//	  1. 보낼 메세지의 정보를 가져온다.
//	  1-1. mng_env_extend 테이블에서 해당 정보를 가져온다. (ok)
//	  1-2. SMS 기능 ON/OFF 여부에 따라 메세지를 보낼지 보내지 않을지 결정한다. (ok)
//	  1-2-1. SMS 기능이 ON이라면 메세지를 보내기 위해 수신할 번호를 찾는다. (ok)
//	  1-2-2. 수신상대는 다수가 될 수 있으며, 입력값을 (XXX-XXXX-XXXX)로 지정했을 때 구분자는 세미콜론(;)으로 한다. (ok)
//	  1-3. 보내야하는 정보를 찾기 위해 로그를 가져온다.
//	  1-3-1. 특정 시간대의 로그를 주기적으로 가져와 확인해야한다. (ok)
//	  1-3-1-1. 시작과 종료 시간을 지정하여 해당 시간에 따른 DB 레코드 추출한다. (ok)
//	  1-3-1-1-1. 시작과 종료 시간은 어떻게 구분 지을 것인가? (ok)
//	  1-1-1-2. yyyy-MM-dd hh:mm:ss 형식이어야 한다. (ok)
//	  1-1-1-3. 만약 해당 시간에 로그가 없다면 어떻게 할 것인가? (ok)
//	  1-3-2. action 값이 1인 로그의 event만 송신한다. (ok)
//	  1-3-2-1. event 값이 길 경우 SMS로 송신할 수 없다. 최대 160자까지이며 한글을 사용하면 80자까지이다. 최대한 줄여야한다. (ok)
//	  
//	  2. 메세지 Db에 저장한다. (ok)
//	  2-1. 보내는 전화번호가 유동적일 필요는 없다. (ok)
//	  2-2. LG SMS 가이드에서 꼭 필요한 컬럼만 값을 넣는다. (ok)
//	  2-2-1. 보내는 날짜와 시간, 전송상태, 메세지 유형, 받는 전화번호, 보내는 전화번호, 메세지 내용 (ok)
//	  2-2-2. 필요한 값 이외엔 null이어도 상관 없으며, 받는 전화번호와 메세지 내용은 유동적이고 그 외는 고정한다. (ok)
//	  2-3. 받는 사람이 다수일 수 있다. (ok)

    @Scheduled(fixedDelay = 20000)
    public void logPullAndParsingWorker() {
        eventDataList = new ArrayList<String>();
        phoneNumberList = new ArrayList<String>();
        List<StartDbTable> alramLog = logService.startEndTimeLog(DEFAULT_START_TIME, DEFAULT_END_TIME);
        try {
            if (smsService.sendCheck()) {
                if (alramLog.isEmpty()) {
                    log.info("발생한 데이터(에러)가 존재하지 않습니다.");
                    return;
                } else {
                    smsSavecheck = true;
                    log.info("데이터를 읽어 옵니다.");
                    eventQueue.add(new EventDTO()
                            .setEvent(logService.startEndTimeLog(DEFAULT_START_TIME, DEFAULT_END_TIME))
                            .setPhoneNumber(logService.phoneNumberList()));

                }
            } else {
                log.info("명령 실행을 종료합니다.");
                smsSavecheck = false;
                return;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    @Scheduled(fixedDelay = 21000)
    public void smsPushWorker() {
        if (!smsSavecheck) {
            return;
        }

        while (true) {
            EventDTO event = eventQueue.poll();
            if (event == null) {
                break;
            }


            for (String eventMsg : event.getEvent().orElse(Arrays.asList())) {
                for (String phoneNumber : event.getPhoneNumber()) {
                    smsService.logSaveSms(eventMsg, phoneCallBack, phoneNumber);
                }
            }

            log.info("DB sms table에 데이터 저장을 완료했습니다.");
//            event.getEvent();
//            event.getPhoneNumber()
//
        }
    }
}
