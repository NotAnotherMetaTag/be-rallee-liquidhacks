package liquidhacks.rallee.ralleebe.controller.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Player {

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
	public String getPlayerById(String id){
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
	public String getPlayersByMaxRank(String maxRank){
		//TODO
		return "GET";
	}
	@GetMapping("/players/{minRank}")
	public String getPlayersByMinRank(String minRank){
		//TODO
		return "GET";
	}
	@GetMapping("/players/{playType}")
	public String getPlayersByType(String playType){
		//TODO
		return "GET";
	}
}