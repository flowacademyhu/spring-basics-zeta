package hu.flowacademy.spring.first.complex.rest;

import hu.flowacademy.spring.first.complex.model.Food;
import hu.flowacademy.spring.first.complex.model.Order;
import hu.flowacademy.spring.first.complex.service.FoodService;
import hu.flowacademy.spring.first.complex.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderResource {

    Logger LOG = LoggerFactory.getLogger(OrderResource.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> findAll() {
        LOG.info("findAll called");
        return orderService.findAll();
    }

    @GetMapping("/order/{id}")
    public Order findOne(@PathVariable Long id) {
        return orderService.findOne(id).orElse(null);
    }

    @PostMapping("/order")
    public Order save(@RequestBody Order order) {
        LOG.info("Order is: {}", order);
        return orderService.save(order);
    }

    @DeleteMapping("/order/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
