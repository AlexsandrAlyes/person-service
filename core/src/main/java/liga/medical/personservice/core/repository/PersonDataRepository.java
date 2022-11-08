package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.dto.model.PersonData;
import liga.medical.personservice.core.mapper.PersonDataRowMapper;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDataRepository extends CrudRepository<PersonData, Long> {

    @Query(value = "select * from (select * from clinic.person_data pd inner join" +
            " clinic.medical_card mc on pd.medical_card_id = mc.id inner join " +
            "clinic.contact c on c.id = pd.contact_id inner" +
            " join clinic.address ad on ad.contact_id = c.id inner join" +
            " clinic.illness i on i.medical_card_id = mc.id " +
            "where pd.id = :id) as t left join " +
            "clinic.person_data ppd on t.parent_id = ppd.id",
            rowMapperClass = PersonDataRowMapper.class)
    PersonData getPersonDataById(@Param("id")Long id);

    List<PersonData> findAll();
}
