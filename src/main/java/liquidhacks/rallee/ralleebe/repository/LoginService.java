package liquidhacks.rallee.ralleebe.repository;

import liquidhacks.rallee.ralleebe.model.UserDTO;

import java.util.List;
import java.util.Optional;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface LoginService extends CrudRepository<UserDTO, String> {

	@SuppressWarnings("unchecked")
	public UserDTO save(UserDTO user);

	public Optional<UserDTO> findByEmail(String email);
	public Optional<UserDTO> findById(String id);

	public List<UserDTO> findAll();
}