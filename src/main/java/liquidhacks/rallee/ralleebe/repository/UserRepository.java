package liquidhacks.rallee.ralleebe.repository;

import org.springframework.data.repository.CrudRepository;

import liquidhacks.rallee.ralleebe.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

  boolean existsByUsername(String username);

  User findByUsername(String username);

  void deleteByUsername(String username);
}