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
@Table("illness")
public class Illness {

    @Id
    private long id;
    private long typeId;
    private String heaviness;
    private java.sql.Timestamp appearanceDttm;
    private java.sql.Date recoveryDt;
    @MappedCollection(idColumn = "id")
    private MedicalCard medicalCard;
}