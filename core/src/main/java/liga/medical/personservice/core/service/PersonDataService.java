package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.entity.PersonData;

import java.util.List;

public interface PersonDataService {

    List<PersonData> getAllPersonData();

    PersonData getPersonDataById(long id);

    PersonData savePersonData(PersonData personData);

    void deletePersonDataById(long id);

}