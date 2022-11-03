package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.annotations.Loggable;
import liga.medical.personservice.core.dto.model.LogDTO;
import liga.medical.personservice.core.dto.model.UserDTO;
import liga.medical.personservice.core.service.LogService;
import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.core.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

import javax.xml.bind.ValidationException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@ApiIgnore
public class SecurityController {

    private final UserService userService;
    private final UserValidator validator;
    private final LogService logService;

    @GetMapping("/login")
    @Loggable
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/reg")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@ModelAttribute UserDTO userDTO, BindingResult result, Model model) {
        validator.validate(userDTO, result);

        if (result.hasErrors()) {
            List<FieldError> errorList = result.getFieldErrors();
            model.addAttribute("myerror", errorList);
            model.addAttribute("user", userDTO);

            StringBuilder error = new StringBuilder();
            errorList.forEach(s -> error.append(s.getDefaultMessage()).append("; "));
            try {
                throw new ValidationException("non-compliance with the registration form", error.toString());
            } catch (ValidationException e) {

                log.info("Регистрация провалена: были введены следующие данные: username : [" +
                        userDTO.getUsername() + "] password : [" + userDTO.getPassword() + "] " + error);

                logService.addLogInDB(new LogDTO(LocalDateTime.now(),
                        "ERROR",
                        log.getName() + ".addUser",
                        "Регистрация провалена: были введены следующие данные: username : [" +
                                userDTO.getUsername() + "] password : [" + userDTO.getPassword() + "] " + error,
                        "anonymousUser")
                );

            }
            return "reg";
        }
        userService.addUserInDB(userDTO);

        log.info("Регистрация прошла успешно: были введены следующие данные: username : [" +
                userDTO.getUsername() + "] password : [" + userDTO.getPassword() + "] ");

        logService.addLogInDB(new LogDTO(LocalDateTime.now(),
                "INFO",
                log.getName() + ".addUser",
                "Регистрация прошла успешно, были введены следующие данные: username : [" +
                        userDTO.getUsername() + "]  password : [" + userDTO.getPassword() + "]",
                "anonymousUser")
        );
        return "login";
    }
}
