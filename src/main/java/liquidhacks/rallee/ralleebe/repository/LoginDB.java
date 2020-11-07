package liquidhacks.rallee.ralleebe.repository;

import liquidhacks.rallee.ralleebe.model.UserDTO;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

public interface LoginDB extends CrudRepository<UserDTO, String> {

  @SuppressWarnings("unchecked")
public UserDTO save(UserDTO user);
  
  @EnableScan
  public Iterable findAll();
}