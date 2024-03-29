package hu.flowacademy.spring.first.basic_workflow;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/***
 *
 * BasicResource is a CRUD Resource
 *
 */
@RestController
@RequestMapping("/api/basic")
public class BasicResource {

  @Autowired
  private BasicService basicService;

  @GetMapping("/")
  public List<BasicModel> findAll() {
    return basicService.findAll();
  }

  @GetMapping("/name")
  public List<BasicModel> findByName(@RequestParam("name") String name){
    return basicService.findByName(name);
  }

  @GetMapping("/{id}")
  public BasicModel findOne(@PathVariable Long id) {
    return basicService.findOne(id);
  }

  @PostMapping("/")
  public BasicModel save(@RequestBody BasicModel basicModel) {
    return basicService.save(basicModel);
  }

  @PutMapping("/")
  public BasicModel update(@RequestBody BasicModel basicModel) {
    return basicService.update(basicModel);
  }

//  @PutMapping("/{id}")
//  public BasicModel updateWithId(@PathVariable Long id, @RequestBody BasicModel basicModel) {
//    return basicService.update(id, basicModel);
//  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    basicService.delete(id);
    return ResponseEntity.ok().build();
  }

}
