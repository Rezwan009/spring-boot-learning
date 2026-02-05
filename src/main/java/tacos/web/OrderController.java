package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import tacos.Taco;
import tacos.TacoOrder;
import tacos.data.OrderRepository;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "orderForm";
        }
        for (Taco taco : order.getTacos()) {
            taco.setTacoOrder(order);   // ← THIS MUST HAPPEN
        }
        orderRepository.save(order);
        log.info("Order Submitted{}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
