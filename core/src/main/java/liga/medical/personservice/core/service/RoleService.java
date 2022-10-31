package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.mapping.RoleMapper;
import liga.medical.personservice.core.dto.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleMapper roleMapper;

    public Set<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public Role getRoleFromDBByName(String name) {
        return roleMapper.getRoleByNameFromDB(name);
    }
}
