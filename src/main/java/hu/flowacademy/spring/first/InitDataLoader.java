package hu.flowacademy.spring.first;

import hu.flowacademy.spring.first.basic_workflow.BasicModel;
import hu.flowacademy.spring.first.basic_workflow.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class InitDataLoader implements ApplicationRunner {

    private Object[][] data = new Object[][]{
            {"Feri", "55"},
            {"Tasi", "66"},
            {"Kata", "44"},
            {"Vasrudas", "33"},
            {"Andor", "234567"},
    };

    @Autowired
    private BasicService basicService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        clearBasicModels();
        initBasicModels();
    }

    private void initBasicModels() {
        Stream.of(data).map(line ->
                new BasicModel((String)line[0],(String) line[1]))
        .forEach(basicService::save);
    }

    private void clearBasicModels() {
        basicService.deleteAll();
    }
}
