package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.entity.Exception;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends CrudRepository<Exception, Long> {
}
