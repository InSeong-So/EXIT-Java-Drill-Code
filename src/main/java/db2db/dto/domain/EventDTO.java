package db2db.dto.domain;

import java.util.List;
import java.util.Optional;

import db2db.startdb.domain.StartDbTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

	List<String> event;
	List<String> phoneNumber;

	public EventDTO setEvent(List<StartDbTable> alramLogs) {
		for (StartDbTable logs : alramLogs) {
			event.add(logs.getEvent());
		}
		return this;
	}

	public EventDTO setPhoneNumber(List<String> nums) {
		this.phoneNumber = nums;
		return this;
	}

	public Optional<List<String>> getEvent() {

		if (event == null) {
			return Optional.empty();
		}
		return Optional.of(event);
	}
}
