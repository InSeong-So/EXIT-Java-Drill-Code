package db2db.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum StartDbType {
    SUCCESS("0"),FAIL("1"),TIMEOUT("2");

    private String msgType;

}
