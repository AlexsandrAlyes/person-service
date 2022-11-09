package liga.medical.personservice.core.dto.model;

import lombok.Data;

@Data
public class MessageDTO {

    private int id;

    private MessageStatus type;

    private String description;
}
