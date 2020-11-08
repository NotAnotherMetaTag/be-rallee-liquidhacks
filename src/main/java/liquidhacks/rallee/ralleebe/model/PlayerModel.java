package liquidhacks.rallee.ralleebe.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import liquidhacks.rallee.ralleebe.model.enums.LanguagesEnum;

@DynamoDBTypeConverted(converter = liquidhacks.rallee.ralleebe.config.ObjectConverter.class)
@DynamoDBTable(tableName = "Player")
public class PlayerModel {

	private String username;
	@NotNull
    @NotEmpty
	private String email;
	private List<LanguagesEnum> languages;
	private List<GameModel> gamesPlayed;
	private String profilePictureURL = "";
	private String location;

	public PlayerModel() {

	}

	
	public PlayerModel(String username, String email, List<LanguagesEnum> languages, List<GameModel> gamesPlayed,
			String profilePictureURL, String location) {
		super();
		this.username = username;
		this.email = email;
		this.languages = languages;
		this.gamesPlayed = gamesPlayed;
		this.profilePictureURL = profilePictureURL;
		this.location = location;
	}

	@DynamoDBHashKey
	@DynamoDBAttribute
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LanguagesEnum> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguagesEnum> languages) {
		this.languages = languages;
	}

	public List<GameModel> getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(List<GameModel> gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public String getProfilePictureURL() {
		return profilePictureURL;
	}

	public void setProfilePictureURL(String profilePictureURL) {
		this.profilePictureURL = profilePictureURL;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}