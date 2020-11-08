package liquidhacks.rallee.ralleebe.repository;

import liquidhacks.rallee.ralleebe.model.GameModel;
import liquidhacks.rallee.ralleebe.model.PlayerModel;
import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface GameService extends CrudRepository<GameModel, String> {
	//public List<PlayerModel> findPlayersByMaxRank(int maxRank);
	public List<PlayerModel> findPlayersByIsCasual(boolean isCasual);
	public List<PlayerModel> findPlayersByIsCompetitive(boolean isCompetitive);
	public PlayerModel findByRank(int rank);
}