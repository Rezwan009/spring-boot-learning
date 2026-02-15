package tacos.security;

//@Controller
//@RequestMapping("/register")
//public class RegistrationController {
//
//    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping
//    public String registerForm(Model model) {
//
//        model.addAttribute("user", new RegistrationRequest());
//        return "registerForm";
//    }
//
//    @PostMapping
//    public String processRegistration(@Valid @ModelAttribute("user") RegistrationRequest form,
//                                      Errors errors) {
//
//        if (errors.hasErrors()) {
//            return "registerForm";
//        }
//        userRepository.save(form.toUser(passwordEncoder));
//
//        return "redirect:/login";
//    }
//}
