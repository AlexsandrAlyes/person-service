package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.dao.UserDAO;
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

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class SecurityController {

    private final UserService userService;
    private final UserValidator validator;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/reg")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDAO());
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@ModelAttribute UserDAO userDAO, BindingResult result, Model model) {
        validator.validate(userDAO, result);
        log.info(userDAO.toString());
        if (result.hasErrors()) {
            List<FieldError> errorList = result.getFieldErrors();
            errorList.forEach(s -> log.error(s.getDefaultMessage()));
            model.addAttribute("myerror", errorList);
            model.addAttribute("user", userDAO);
            return "reg";
        }
        log.info(userDAO.toString());
        log.info("post");
        userService.addUserInDB(userDAO);
        return "login";
    }
}
