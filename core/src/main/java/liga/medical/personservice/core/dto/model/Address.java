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
@Table("address")
public class Address {

    @Id
    private long id;

    private long countryId;

    private String city;

    private long index;

    private String street;

    private String building;

    private String flat;

    @MappedCollection(idColumn = "id")
    private Contact contact;

}
