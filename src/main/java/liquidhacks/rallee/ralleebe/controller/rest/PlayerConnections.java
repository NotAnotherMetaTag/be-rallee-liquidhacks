package liquidhacks.rallee.ralleebe.controller.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PlayerConnections {

	@GetMapping("/connections")
	public String getConnections(){
		//TODO
		return "GET";
	}
	
	@GetMapping("/connections/{id}")
	public String getMessageById(String id){
		//TODO
		return "GET";
	}
	
	@PostMapping("/connections")
	public String postMessageById(String id){
		//TODO
		return "POST";
	}
	
	@PostMapping("/connections/webook")
	public String subscribeToMessages(String id){
		//TODO
		return "POST";
	}
	
	@PostMapping("/like/")
	public String likeUser(String id){
		//TODO
		return "POST";
	}
	
	@DeleteMapping("/like/")
	public String unlikeUser(String id){
		//TODO
		return "DELETE";
	}
}