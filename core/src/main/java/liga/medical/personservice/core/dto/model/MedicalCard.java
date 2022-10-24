package liga.medical.personservice.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table("medical_card")
public class MedicalCard {

    @Id
    private long id;
    private String clientStatus;
    private String medStatus;
    private java.sql.Date registryDate;
    private String comment;

}
