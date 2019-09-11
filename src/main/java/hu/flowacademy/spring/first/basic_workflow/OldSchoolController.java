package hu.flowacademy.spring.first.basic_workflow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/oldschool")
public class OldSchoolController {

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/json-data")
    @ResponseBody
    public List<String> getJsonResponse() {
        return List.of("Tadam, there is a JSON response", "Ohh :O I made another");
    }
}
