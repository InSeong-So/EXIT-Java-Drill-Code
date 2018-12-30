package db2db.startdb.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "log_adc_alarm")
public class StartDbTable {

	@Id
//	@SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence")
//	@GeneratedValue(strategy = GenerationType.AUTO, generator = "hibernate_sequence")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "index")
	private Long index;

	@Column(name = "occur_time")
	private Timestamp occurTime;

	@Column(name = "alarm_time")
	private Timestamp alarmTime;

	@Column(name = "ADC_INDEX")
	private Integer adcIndex;

	@Column(name = "adc_name", length = 100)
	private String adcName;

	@Column(name = "class")
	private Integer classId;

	@Column(name = "type")
	private Integer type;

	@Column(name = "status")
	private Integer status;

	@Column(name = "object_type")
	private Integer objectType;

	@Column(name = "object", length = 100)
	private String object;

	@Column(name = "relative_object_type")
	private Integer relativeObjectType;

	@Column(name = "relative_object", length = 100)
	private String relativeObject;

	@Column(name = "event", length = 1000)
	private String event;

	@Column(name = "event_eng", length = 1000)
	private String eventEng;

	@Column(name = "action")
	private Integer action;

}
