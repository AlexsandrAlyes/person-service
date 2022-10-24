package liga.medical.personservice.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("person_data")
public class PersonData {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private java.sql.Date birthDate;
    private long age;
    private String sex;
    @MappedCollection(idColumn = "id")
    private Contact contact;
    @MappedCollection(idColumn = "id")
    private MedicalCard medicalCard;
    private long parentId;

}
