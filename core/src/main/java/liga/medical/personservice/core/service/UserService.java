package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.dao.UserDAO;
import liga.medical.personservice.core.dto.mapping.UserMapper;
import liga.medical.personservice.core.dto.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public void addUserInDB(UserDAO userDAO) {
        User user = new User(
                userDAO.getUsername(),
                encoder.encode(userDAO.getPassword())
        );
        log.info(user.toString());
        userMapper.addUserInDB(user);
        Long id = userMapper.findByUsername(userDAO.getUsername()).getId();
        log.info("id", id);
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
