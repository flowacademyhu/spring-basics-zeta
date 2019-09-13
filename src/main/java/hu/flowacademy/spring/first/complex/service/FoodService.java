package hu.flowacademy.spring.first.complex.service;

import hu.flowacademy.spring.first.complex.model.Food;
import hu.flowacademy.spring.first.complex.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Optional<Food> findOne(Long id) {
        return foodRepository.findById(id);
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }

    public void deleteAll() {
        foodRepository.deleteAll();
    }
}
