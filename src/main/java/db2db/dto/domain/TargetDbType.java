package db2db.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public enum TargetDbType {
    SUCCESS("0"), FAIL("0"), PENDING("1"), TIMEOUT("2");
    private String status;
}

