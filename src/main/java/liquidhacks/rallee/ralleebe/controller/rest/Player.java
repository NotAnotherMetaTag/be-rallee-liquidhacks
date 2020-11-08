package liquidhacks.rallee.ralleebe.controller.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import liquidhacks.rallee.ralleebe.model.GameModel;
import liquidhacks.rallee.ralleebe.model.PlayerModel;
import liquidhacks.rallee.ralleebe.model.enums.GameOptionsEnum;
import liquidhacks.rallee.ralleebe.model.enums.LanguagesEnum;
import liquidhacks.rallee.ralleebe.repository.PlayerService;

@RestController
@CrossOrigin()
//@PreAuthorize("isAuthenticated()")
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class Player {
	
	@Autowired
	private PlayerService playerService;

	@GetMapping("/player")
	public List<PlayerModel> getAllPlayers() {
		return (List<PlayerModel>) playerService.findAll();
	}
	
	@PostMapping("/player")
	public PlayerModel createPlayer(String email, String username, List<String> languages, String location, String gameName){
		PlayerModel player = new PlayerModel();
		GameModel game = new GameModel();
		List<LanguagesEnum> languagesEnumList = new ArrayList<LanguagesEnum>();
		for(String userLang : languages) {
			for(LanguagesEnum lang : LanguagesEnum.values()) {
				if(lang.toString().equalsIgnoreCase(userLang)) {
					languagesEnumList.add(lang);
				}
			}
		}

		for(GameOptionsEnum gameOption : GameOptionsEnum.values()) {
				if(gameOption.toString().equalsIgnoreCase(gameName)) {
					game.setName(gameName);
				}
		}
		//System.out.println("auth test " + auth.getName());
		player.setEmail(email);
		player.setUsername(username);
		player.setLanguages(languagesEnumList);
		if(!game.getName().isEmpty()) {
			List<GameModel> gameList = new ArrayList<GameModel>();
			gameList.add(game);
			player.setGamesPlayed(gameList);
		}
		player.setLocation(location);
		player.setProfilePictureURL("");
		System.out.println(player.toString());
		System.out.println("Made it through the post funciton");
		player = playerService.save(player);
		return player;
	}
	
	@PutMapping("/player")
	public String updatePlayer(){
		//TODO
		return "PUT";
	}
	
	@DeleteMapping("/player")
	public String deletePlayer(){
		//TODO
		return "DELETE";
	}
	
	@GetMapping("/player/{id}")
	public String getPlayerById(UUID id){
		//TODO
		return "GET";
	}
	
	@GetMapping("/players/{game}")
	public String getPlayersByGame(String game){
		//TODO
		return "GET";
	}
	@GetMapping("/players/{language}")
	public String getPlayersByLanguage(String language){
		//TODO
		return "GET";
	}
	@GetMapping("/players/{location}")
	public String getPlayersByLocation(String location){
		//TODO
		return "GET";
	}
	@GetMapping("/players/{maxRank}")
	public String getPlayersByMaxRank(int maxRank){
		//TODO
		return "GET";
	}
	@GetMapping("/players/{minRank}")
	public String getPlayersByMinRank(int minRank){
		//TODO
		return "GET";
	}
	@GetMapping("/players/{playType}")
	public String getPlayersByType(String playType){
		//TODO
		return "GET";
	}
}