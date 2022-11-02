package liga.medical.personservice.core.validator;

import liga.medical.personservice.core.dto.model.UserDTO;
import liga.medical.personservice.core.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserValidator implements Validator {

    private final UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO dao = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "empty",
                "the field cannot be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty",
                "the field cannot be empty");

        if (dao.getPassword().length() < 8 || dao.getPassword().length() > 32) {
            errors.rejectValue("password", "password.range.size.invalid",
                    "password range size invalid(8-32 char)");
        }
        if (dao.getUsername().length() > 32) {
            errors.rejectValue("username", "username.range.size.invalid",
                    "username range size invalid(max 32 char) ");
        }
        if (userService.findByUsername(dao.getUsername()) != null) {
            errors.rejectValue("username", "username.duplicate", "username already in use");
        }
    }

}
