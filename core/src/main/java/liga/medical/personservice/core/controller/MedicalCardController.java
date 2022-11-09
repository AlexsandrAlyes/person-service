package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.dto.entity.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
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
@Api(value = "Api по работе с медицинской картой")
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    @GetMapping("/medical-card")
    @ApiOperation(value = "Получение всех медицинских карт")
    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardService.getAllMedicalCards();
    }

    @GetMapping("/medical-card/{id}")
    @ApiOperation(value = "Получение медицинской карты по id")
    public MedicalCard geMedicalCardById(@PathVariable long id) {
        return medicalCardService.getMedicalCardById(id);
    }

    @PostMapping("/medical-card")
    @ApiOperation(value = "Добавление новой медецинской карты")
    public ResponseEntity<String> addMedicalCardInDB(@RequestBody MedicalCard medicalCard) {
        medicalCardService.saveMedicalCard(medicalCard);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/medical-card/{id}")
    @ApiOperation(value = "Удаление медецинской карты по id")
    public ResponseEntity<String> deleteMedicalCardInDB(@PathVariable long id) {
        medicalCardService.deleteMedicalCardById(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}
