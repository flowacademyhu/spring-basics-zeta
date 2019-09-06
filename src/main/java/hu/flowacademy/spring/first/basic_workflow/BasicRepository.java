package hu.flowacademy.spring.first.basic_workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Repository;

/***
 * BasicRepository stores data
 */
@Repository
public class BasicRepository {

  List<BasicModel> models = new ArrayList<>();

  public List<BasicModel> findAll() {
    return models;
  }

  public BasicModel findOne(Long id) {
    return models.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
  }

  public BasicModel save(BasicModel basicModel) {
    if (basicModel.getId() == null) {
      basicModel.setId(new Random().nextLong());
    }
    models.add(basicModel);
    return basicModel;
  }

  public void delete(Long id) {
    models.removeIf(m -> m.getId().equals(id));
  }
}
