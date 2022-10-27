package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.model.PersonData;
import liga.medical.personservice.core.service.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonDataController {

    private final PersonDataService personDataService;

    @GetMapping("/person-data")
    public List<PersonData> getAllPersonDate() {
        return personDataService.getPersonData();
    }

    @GetMapping("/person-data/{id}")
    public PersonData getPersonDataById(@PathVariable long id) {
        return personDataService.getPersonDataById(id);
    }

    @PostMapping("/person-data")
    public ResponseEntity<String> addPersonDateInDB(@RequestBody PersonData personData) {
        personDataService.addPersonDateInDB(personData);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/person-data/{id}")
    public ResponseEntity<String> deletePersonDateInDB(@PathVariable long id) {
        personDataService.deletePersonDateInDB(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }

}
