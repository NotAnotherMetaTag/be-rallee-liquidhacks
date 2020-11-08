package liquidhacks.rallee.ralleebe.repository;

import liquidhacks.rallee.ralleebe.model.PlayerModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PlayerService extends CrudRepository<PlayerModel, String> {

  public PlayerModel findByUsername(String username);
  public List<PlayerModel> findByEmail(String email);

}