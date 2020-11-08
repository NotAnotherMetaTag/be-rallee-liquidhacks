package liquidhacks.rallee.ralleebe.model;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGenerateStrategy;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBGeneratedUuid;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

@DynamoDBTypeConverted(converter = liquidhacks.rallee.ralleebe.config.ObjectConverter.class)
@DynamoDBTable(tableName = "User")
public class User {
  private UUID id;
  @NotNull
  @NotEmpty
  private String password;
  @NotNull
  @NotEmpty
  private String email;
  @NotNull
  @NotEmpty
  private String username;
  List<Role> roles;

  public User() {

  }

  @DynamoDBHashKey
  @DynamoDBGeneratedUuid(DynamoDBAutoGenerateStrategy.CREATE)
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

}