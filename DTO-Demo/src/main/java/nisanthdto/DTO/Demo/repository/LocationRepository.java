package nisanthdto.DTO.Demo.repository;

import nisanthdto.DTO.Demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
