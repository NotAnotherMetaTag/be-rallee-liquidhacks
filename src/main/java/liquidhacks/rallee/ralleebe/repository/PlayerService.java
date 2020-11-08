package liquidhacks.rallee.ralleebe.repository;

import liquidhacks.rallee.ralleebe.model.PlayerModel;
import java.util.List;
import java.util.UUID;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PlayerService extends CrudRepository<PlayerModel, String> {

	public PlayerModel findByUsername(String username);
	public PlayerModel findByEmail(String email);
	public PlayerModel save(PlayerModel player);
	public List<PlayerModel> findPlayersByGamesPlayed(String game);
	public List<PlayerModel> findPlayersByLocation(String location);
	public List<PlayerModel> findPlayersByLanguages(String language);

}