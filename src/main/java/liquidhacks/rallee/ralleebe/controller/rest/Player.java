package liquidhacks.rallee.ralleebe.controller.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import liquidhacks.rallee.ralleebe.repository.PlayerService;

@RestController
class Player {
	
	@Autowired
	private PlayerService playerService;

	@PostMapping("/player")
	public String createPlayer(){
		//TODO
		return "POST";
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