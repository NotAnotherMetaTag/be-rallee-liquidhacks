package liquidhacks.rallee.ralleebe.dao;

import liquidhacks.rallee.ralleebe.model.Player;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PlayerDAO extends CrudRepository<Player, String> {

  public Player findByUsername(String username);
  public List<Player> findByEmail(String email);

}