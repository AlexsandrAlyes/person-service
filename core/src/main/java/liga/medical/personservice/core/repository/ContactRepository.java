package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

}