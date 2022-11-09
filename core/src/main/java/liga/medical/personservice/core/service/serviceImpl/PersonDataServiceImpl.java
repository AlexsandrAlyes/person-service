package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.PersonData;
import liga.medical.personservice.core.repository.PersonDataRepository;
import liga.medical.personservice.core.service.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonDataServiceImpl implements PersonDataService {

    private final PersonDataRepository personDataRepository;

    @Override
    public List<PersonData> getAllPersonData() {
        List<PersonData> personDataList = new ArrayList<>();
        personDataRepository.findAll().forEach(personDataList::add);
        return personDataList;
    }

    @Override
    public PersonData getPersonDataById(long id) {
        return personDataRepository.findById(id).get();
    }

    @Override
    public PersonData savePersonData(PersonData personData) {
        return personDataRepository.save(personData);
    }

    @Override
    public void deletePersonDataById(long id) {
        personDataRepository.deleteById(id);
    }

}
