package tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(Model model) {

        model.addAttribute("user", new RegistrationRequest());
        return "registerForm";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("user") RegistrationRequest form,
                                      Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }
        userRepository.save(form.toUser(passwordEncoder));

        return "redirect:/login";
    }
}
