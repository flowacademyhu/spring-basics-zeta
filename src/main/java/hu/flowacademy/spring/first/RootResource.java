package hu.flowacademy.spring.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootResource {

  @Autowired
  private MyComponent myComponent;

  @GetMapping("/")
  public String getRoot() {
    return "Hello world!";
  }

  // Elerheto a http://localhost:8081/my-comp url-en
  @GetMapping("/my-comp")
  public String getMyCompsData() {
    return myComponent.data;
  }

  // @TOOD localhost:8081/getData/1/

  // https://www.google.com/search?q=hello+world

  @GetMapping("/echo-string")
  public String echoString(@RequestParam("q") String q) {
    return q;
  }

  @PutMapping("/echo-path/{pathvar}")
  public String getPathvariable(@PathVariable("pathvar") String pathVariable) {
    return pathVariable;
  }

  @PostMapping("/echo-json")
  public Profile getProfile(@RequestBody Profile profile) {
    return profile;
  }
}
