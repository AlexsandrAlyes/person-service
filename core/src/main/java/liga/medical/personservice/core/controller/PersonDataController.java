package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.dto.entity.PersonData;
import liga.medical.personservice.core.service.PersonDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db")
@Api(value = "Api по работе с персональной информаций")
public class PersonDataController {

    private final PersonDataService personDataService;

    @GetMapping("/person-data")
    @ApiOperation(value = "Получение всех персональных информаций ")
    public List<PersonData> getAllPersonDate() {
        return personDataService.getAllPersonData();
    }

    @GetMapping("/person-data/{id}")
    @ApiOperation(value = "Получение персональной информаций по id")
    public PersonData getPersonDataById(@PathVariable long id) {
        return personDataService.getPersonDataById(id);
    }

    @PostMapping("/person-data")
    @ApiOperation(value = "Добавление новой персональной информаций")
    public ResponseEntity<String> addPersonDateInDB(@RequestBody PersonData personData) {
        personDataService.savePersonData(personData);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/person-data/{id}")
    @ApiOperation(value = "Удаление персональной информаций по id")
    public ResponseEntity<String> deletePersonDateInDB(@PathVariable long id) {
        personDataService.deletePersonDataById(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }

}
