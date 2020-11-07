package liquidhacks.rallee.ralleebe.dao;

import liquidhacks.rallee.ralleebe.model.PlayerModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PlayerDAO extends CrudRepository<PlayerModel, String> {

  public PlayerModel findByUsername(String username);
  public List<PlayerModel> findByEmail(String email);

}