package tacos.contorller.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.entity.Taco;
import tacos.entity.TacoOrder;
import tacos.entity.User;
import tacos.data.OrderRepository;
import tacos.data.UserRepository;

import javax.validation.Valid;
import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class OrderController {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

//    public OrderController(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               Principal principal,
                               Authentication authentication,
                               @AuthenticationPrincipal User user) {

        if (errors.hasErrors()) {
            return "orderForm";
        }
        // We can get Logged user in this three ways
//       No 1: Principal principal
            // User user = userRepository.findByUsername(principal.getName());
//       No 2: Authentication authentication
            // User user = (User) authentication.getPrincipal();
//       No 3: @AuthenticationPrincipal User user
//       No 4: SecurityContextHolder
        // Authentication authentication1 = SecurityContextHolder.getContext().getAuthentication();
        // User user1 = (User) authentication1.getPrincipal();





        order.setUser(user);
        for (Taco taco : order.getTacos()) {
            taco.setTacoOrder(order);   // ← THIS MUST HAPPEN
        }
        orderRepository.save(order);
        log.info("Order Submitted{}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
