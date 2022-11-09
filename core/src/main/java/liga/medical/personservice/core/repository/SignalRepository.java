package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.entity.Signal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignalRepository extends CrudRepository<Signal, Long> {
}
