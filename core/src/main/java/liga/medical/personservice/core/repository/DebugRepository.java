package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.entity.Debug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebugRepository extends CrudRepository<Debug, Long> {
}
