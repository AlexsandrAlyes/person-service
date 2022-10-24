package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.model.PersonData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDataRepository extends CrudRepository<PersonData, Long> {
}
