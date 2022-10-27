package liga.medical.personservice.core.dto.model;

import lombok.Data;

@Data
public class Address {

    private long id;
    private long countryId;
    private String city;
    private long index;
    private String street;
    private String building;
    private String flat;
    private long contactId;

}
