package hu.flowacademy.spring.first.complex.service;

import hu.flowacademy.spring.first.complex.model.Food;
import hu.flowacademy.spring.first.complex.model.Order;
import hu.flowacademy.spring.first.complex.repository.FoodRepository;
import hu.flowacademy.spring.first.complex.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> findOne(Long id) {
        return orderRepository.findById(id);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
