package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.model.UserDTO;
import liga.medical.personservice.core.dto.mapping.UserMapper;
import liga.medical.personservice.core.dto.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public void addUserInDB(UserDTO userDTO) {
        User user = new User(
                userDTO.getUsername(),
                encoder.encode(userDTO.getPassword())
        );
        userMapper.addUserInDB(user);
        Long id = userMapper.findByUsername(userDTO.getUsername()).getId();
        userMapper.assigningRoleToUSer(id, 2L);
    }

    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return null;
        }
        user.setRoleSet(userMapper.getUserRoles(user.getId()));
        return user;
    }
}
