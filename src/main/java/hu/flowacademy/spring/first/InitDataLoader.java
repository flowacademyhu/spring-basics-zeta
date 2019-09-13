package hu.flowacademy.spring.first;

import hu.flowacademy.spring.first.basic_workflow.BasicModel;
import hu.flowacademy.spring.first.basic_workflow.BasicService;
import hu.flowacademy.spring.first.complex.model.Food;
import hu.flowacademy.spring.first.complex.model.Order;
import hu.flowacademy.spring.first.complex.service.FoodService;
import hu.flowacademy.spring.first.complex.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InitDataLoader implements ApplicationRunner {

    private Object[][] basicData = new Object[][]{
            {"Feri", "55"},
            {"Tasi", "66"},
            {"Kata", "44"},
            {"Vasrudas", "33"},
            {"Andor", "234567"},
    };

    @Autowired
    private BasicService basicService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderService orderService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clearBasicModels();
        initBasicModels();

        clearFoods();
        clearOrders();
        var foods = initFoods();
        initOrders(foods);
    }

    private void initOrders(List<Food> foods) {
        Stream.of("Karasz utca 5", "Merey u 2")
                .map(addr -> new Order(
                        foods.get(new Random().nextInt(foods.size())),
                        addr,
                        BigDecimal.valueOf(new Random().nextInt(10000))
                 )
                ).forEach(orderService::save);
    }

    private List<Food> initFoods() {
        return Stream.of("Pizza", "Kakaos csiga", "Pacal")
                .map(Food::new)
                .peek(foodService::save)
                .collect(Collectors.toList());
    }

    private void clearOrders() {
        orderService.deleteAll();
    }

    private void clearFoods() {
        foodService.deleteAll();
    }

    private void initBasicModels() {
        Stream.of(basicData).map(line ->
                new BasicModel((String)line[0],(String) line[1]))
        .forEach(basicService::save);
    }

    private void clearBasicModels() {
        basicService.deleteAll();
    }
}
