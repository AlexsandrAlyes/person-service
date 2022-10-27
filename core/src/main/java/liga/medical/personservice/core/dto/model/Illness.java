package liga.medical.personservice.core.dto.model;

import lombok.Data;

@Data
public class Illness {

    private long id;
    private long typeId;
    private String heaviness;
    private java.sql.Timestamp appearanceDttm;
    private java.sql.Date recoveryDt;
    private long medicalCardId;

}
