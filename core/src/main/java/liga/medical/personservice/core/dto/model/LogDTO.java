package liga.medical.personservice.core.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LogDTO {
    private LocalDateTime logDateTime;
    private String level;
    private String logger;
    private String message;
    private String username;

}
