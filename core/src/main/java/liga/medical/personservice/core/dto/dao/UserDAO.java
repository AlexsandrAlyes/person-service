package liga.medical.personservice.core.dto.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {

    private Long id;
    private String username;
    private String password;

}
