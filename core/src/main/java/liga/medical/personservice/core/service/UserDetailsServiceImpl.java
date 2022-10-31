package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Lazy
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        user.getRoleSet().forEach(role -> grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName())));
        log.info("USERDETAILSSERVICEIMPL");
        log.info(user.toString());
        log.info(grantedAuthoritySet.toString());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantedAuthoritySet
        );
    }
}
