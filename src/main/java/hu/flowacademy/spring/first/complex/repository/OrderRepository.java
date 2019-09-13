package hu.flowacademy.spring.first.complex.repository;

import hu.flowacademy.spring.first.complex.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
