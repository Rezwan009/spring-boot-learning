package tacos.contorller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tacos.entity.TacoOrder;
import tacos.repository.OrderRepository;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/orders", produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class OrderController {

    private final OrderRepository orderRepository;

    @PutMapping(path = "/{orderId}",consumes = "application/json")
    public TacoOrder updateOrder(@PathVariable("orderId") Long orderId, @RequestBody TacoOrder order){

        order.setId(orderId);
        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        try {
            orderRepository.deleteById(orderId);
        }catch (EmptyResultDataAccessException e){
            System.out.println(e.getMessage());
        }
    }
}
