package liquidhacks.rallee.ralleebe.model;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBGeneratedUuid;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTypeConverted(converter = ObjectConverter.class)
@DynamoDBTable(tableName = "User")
public class UserDTO
{
	private UUID id;
	@NotNull
    @NotEmpty
	private String username;
	@NotNull
    @NotEmpty
	private String password;
	private String matchingPassword;
	@NotNull
    @NotEmpty
	private String email;

	public UserDTO() {

	}

	@DynamoDBHashKey
	@DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
	public UUID getId() {
		return id;
	}

	@DynamoDBAttribute
	public String getUsername() {
		return username;
	}

	@DynamoDBAttribute
	public String getPassword() {
		return password;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

}