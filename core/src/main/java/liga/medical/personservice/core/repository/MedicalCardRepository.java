package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.model.MedicalCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCardRepository extends CrudRepository<MedicalCard,Long> {
}
