package liga.medical.personservice.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
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

    @MappedCollection(idColumn = "id",keyColumn = "contact_id")
    private Contact contact;

    @MappedCollection(idColumn = "id",keyColumn = "medical_card_id")
    private MedicalCard medicalCard;

    private List<PersonData> parents;

}
