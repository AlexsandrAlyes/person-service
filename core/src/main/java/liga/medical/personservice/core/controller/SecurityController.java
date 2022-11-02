package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.model.UserDTO;
import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.core.validator.UserValidator;
import lombok.RequiredArgsConstructor;
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
public class SecurityController {

    private final UserService userService;
    private final UserValidator validator;

    @GetMapping("/login")
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
            return "reg";
        }
        userService.addUserInDB(userDTO);
        return "login";
    }
}
