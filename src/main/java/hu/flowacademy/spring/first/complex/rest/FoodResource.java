package hu.flowacademy.spring.first.complex.rest;

import hu.flowacademy.spring.first.complex.model.Food;
import hu.flowacademy.spring.first.complex.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodResource {

    @Autowired
    private FoodService foodService;

    @GetMapping("/foods")
    public List<Food> findAll() {
        return foodService.findAll();
    }

    @GetMapping("/food/{id}")
    public Food findOne(@PathVariable Long id) {
        return foodService.findOne(id).orElse(null);
    }

    @PostMapping("/food")
    public Food save(@RequestBody Food food) {
        return foodService.save(food);
    }

    @DeleteMapping("/food/{id}")
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }
}
