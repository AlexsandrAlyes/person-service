package liga.medical.personservice.core.dto.model;

import lombok.Data;

@Data
public class MedicalCard {

    private long id;
    private String clientStatus;
    private String medStatus;
    private java.sql.Date registryDate;
    private String comment;

}
