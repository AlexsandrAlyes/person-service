package liga.medical.personservice.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("contact")
public class Contact {

    @Id
    private long id;
    private String phoneNumber;
    private String email;
    private String profileLink;

}
