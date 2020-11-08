package liquidhacks.rallee.ralleebe.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import liquidhacks.rallee.ralleebe.model.User;

@EnableScan
@Repository
public interface UserRepository extends CrudRepository<User, String> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  void deleteByUsername(String username);
}