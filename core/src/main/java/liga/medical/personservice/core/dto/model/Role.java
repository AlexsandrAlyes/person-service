package liga.medical.personservice.core.dto.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;

@Data
public class Role implements GrantedAuthority {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
