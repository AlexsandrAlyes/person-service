package liga.medical.personservice.core.dto.model;

import lombok.Data;

@Data
public class PersonData {

    private long id;
    private String firstName;
    private String lastName;
    private java.sql.Date birthDate;
    private long age;
    private String sex;
    private long contactId;
    private long medicalCardId;
    private long parentId;

}
