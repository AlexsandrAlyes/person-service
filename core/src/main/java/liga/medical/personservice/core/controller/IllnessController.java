package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.dto.entity.Illness;
import liga.medical.personservice.core.service.IllnessService;
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
@Api(value = "Api по работе с болезнями")
public class IllnessController {

    private final IllnessService illnessService;

    @GetMapping("/illness")
    @ApiOperation(value = "Получение всех болезней")
    public List<Illness> getAllIllness() {
        return illnessService.getAllIllnesses();
    }

    @GetMapping("/illness/{id}")
    @ApiOperation(value = "Получение болезни по id")
    public Illness geIllnessById(@PathVariable long id) {
        return illnessService.getIllnessById(id);
    }

    @PostMapping("/illness")
    @ApiOperation(value = "Добавление новой болезни")
    public ResponseEntity<String> addIllnessInDB(@RequestBody Illness illness) {
        illnessService.saveIllness(illness);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/illness/{id}")
    @ApiOperation(value = "Удаление болезни по id")
    public ResponseEntity<String> deleteIllnessInDB(@PathVariable long id) {
        illnessService.deleteIllnessById(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}
