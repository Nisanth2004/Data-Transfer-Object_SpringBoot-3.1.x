package nisanthdto.DTO.Demo.repository;

import nisanthdto.DTO.Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{

}
