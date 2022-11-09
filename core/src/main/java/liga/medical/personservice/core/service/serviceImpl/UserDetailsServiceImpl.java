package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.model.LogDTO;
import liga.medical.personservice.core.dto.model.User;
import liga.medical.personservice.core.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Lazy
    private final UserService userService;
    private final LogService logService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username);
        if (user == null) {
            log.error("Попытка входа в систему, имя пользователя был введен : [ " + username + " ]" +
                    " имя пользователя : anonymousUser");

            logService.addLogInDB(new LogDTO(LocalDateTime.now(),
                    "ERROR",
                    log.getName(),
                    "Попытка входа в систему, имя пользователя был введен : [ " + username + " ]",
                    "anonymousUser")
            );

            throw new UsernameNotFoundException("User" + username + "not found");
        }
        log.info("Вход выполнен, имя пользователя был введен : [ " + username + " ]" +
                " имя пользователя : " + username);

        logService.addLogInDB(new LogDTO(LocalDateTime.now(),
                "INFO",
                log.getName(),
                "Вход выполнен, имя пользователя был введен : [ " + username + " ]",
                username)
        );

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        user.getRoleSet().forEach(role -> grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantedAuthoritySet
        );
    }
}
