package hu.flowacademy.spring.first.basic_workflow;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/***
 * BasicService contains the business logic
 */
@Service
@Transactional
public class BasicService {

  @Autowired
  private BasicRepository basicRepository;

  public List<BasicModel> findAll() {
    return basicRepository.findAll();
  }

  public BasicModel findOne(Long id) {
    if (id == null) {
      return null;
      // throw new EntityNotFoundException();
    }
    return basicRepository.findById(id).get();
  }

  public BasicModel save(BasicModel basicModel) {
    if (basicModel.getId() != null) {
      throw new RuntimeException(); // @TODO specify it e.g.: InvalidParameterException()
    }
    return basicRepository.save(basicModel);
  }

  public BasicModel update(BasicModel basicModel) {
    if (basicModel.getId() == null) {
      return save(basicModel);
    }
    return basicRepository.save(basicModel);
  }

  public void delete(Long id) {
    if (id == null) {
      throw new RuntimeException();
    }
    basicRepository.deleteById(id);
  }

  public List<BasicModel> findByName(String name) {
    return basicRepository.findByName(name);
  }

  public void deleteAll() {
    basicRepository.deleteAll();
  }
}
