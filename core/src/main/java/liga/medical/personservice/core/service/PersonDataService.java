package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.mapping.PersonDataMapper;
import liga.medical.personservice.core.dto.model.PersonData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonDataService {

    private final PersonDataMapper personDataMapper;

    public List<PersonData> getPersonData() {
        return personDataMapper.listPersonData();
    }

    public PersonData getPersonDataById(long id) {
        return personDataMapper.getPersonDateById(id);
    }

    public void addPersonDateInDB(PersonData personData) {
        personDataMapper.addPersonDateInDB(personData);
    }

    public void deletePersonDateInDB(long id) {
        personDataMapper.deletePersonDateById(id);
    }
}
