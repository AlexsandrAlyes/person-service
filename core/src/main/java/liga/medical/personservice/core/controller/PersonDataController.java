package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.model.PersonData;
import liga.medical.personservice.core.repository.PersonDataRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonDataController {

    private final PersonDataRepository personDataRepository;

    @GetMapping("/person/{id}")
    public PersonData getPersonDataById(@PathVariable long id){
        return new ModelMapper().map(personDataRepository.getPersonDataById(id),PersonData.class);
    }


}
