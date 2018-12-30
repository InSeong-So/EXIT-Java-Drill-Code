package db2db.targetdb.domain;

import java.util.Date;

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
@Table(name = "sms")
public class TargetDbTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TR_NUM")
	private Long trNum;// 메시지 고유번호로 자동 증가됨

	@Column(name = "TR_SENDDATE")
	private Date trSendDate;// 메시지를 전송할 시간, 미래 시간을 넣으면 예약 발송됨

	@Column(name = "TR_ID", length = 16)
	private String trId;// 고객이 발급한 SubID 로 NULL값 이어도 됨

	@Column(name = "TR_SENDSTAT", length = 1)
	private String trSendStat;// 발송상태 0 : 발송대기 1 : 전송완료 2 : 결과수신완료

	@Column(name = "TR_RSLTSTAT", length = 2)
	private String trRsltStat;// 발송 결과수신 값으로 세부 사항은 결과 코드표 참조

	@Column(name = "TR_MSGTYPE", length = 1)
	private String trMsgType;// 문자전송 형태 0 : 일반메시지 1 : 콜백 URL 메시지

	@Column(name = "TR_PHONE", length = 20)
	private String trPhone;// 수신할 핸드폰 번호

	@Column(name = "TR_CALLBACK", length = 20)
	private String trCallback;// 송신자 핸드폰 번호

	@Column(name = "TR_RSLTDATE")
	private Date trRsltDate;// 이동통신사로부터 결과를 통보 받은 시간

	@Column(name = "TR_MODIFIED")
	private Date trModified;// 프로그램 내부적으로 사용

	@Column(name = "TR_MSG", length = 160)
	private String trMsg;// 전송할 메세지

	@Column(name = "TR_NET", length = 4)
	private String trNet;// 전송 완료 후 최종 이동통신사 정보 (011,016,019,000)

	@Column(name = "TR_ETC1", length = 160)
	private String trEtc1;// 기타 필드1 (사용자가 자유롭게 값을 입력하여 사용 가능)

	@Column(name = "TR_ETC2", length = 160)
	private String trEtc2;// 기타 필드1 (사용자가 자유롭게 값을 입력하여 사용 가능)

	@Column(name = "TR_ETC3", length = 160)
	private String trEtc3;// 기타 필드1 (사용자가 자유롭게 값을 입력하여 사용 가능)

	@Column(name = "TR_ETC4", length = 160)
	private String trEtc4;// 기타 필드1 (사용자가 자유롭게 값을 입력하여 사용 가능)

	@Column(name = "TR_ETC5", length = 160)
	private String trEtc5;// 기타 필드1 (사용자가 자유롭게 값을 입력하여 사용 가능)

	@Column(name = "TR_ETC6", length = 160)
	private String trEtc6;// 기타 필드1 (사용자가 자유롭게 값을 입력하여 사용 가능)

	@Column(name = "TR_REALSENDDATE")
	private Date trRealSendDate;// 실제 모듈이 발송(DELIVER)한 시간

	@Column(name = "TR_ROUTEID", length = 20)
	private String trRouteId;// 실제 발송한 세션 ID

}
