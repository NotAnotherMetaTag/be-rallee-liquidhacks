package liquidhacks.rallee.ralleebe.model;

public class PlayerModel {

	private String username;
	private String firstName;
	private String lastName;
	private String email;

	public PlayerModel() {

	}

	public PlayerModel(String username, String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}