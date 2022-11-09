package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}

