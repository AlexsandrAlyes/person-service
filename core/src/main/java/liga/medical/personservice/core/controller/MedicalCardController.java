package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.model.MedicalCard;
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
public class MedicalCardController {

    private final MedicalCardService medicalCardService;

    @GetMapping("/medical-card")
    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardService.getAllMedicalCard();
    }

    @GetMapping("/medical-card/{id}")
    public MedicalCard geMedicalCardById(@PathVariable long id) {
        return medicalCardService.getMedicalCardById(id);
    }

    @PostMapping("/medical-card")
    public ResponseEntity<String> addMedicalCardInDB(@RequestBody MedicalCard medicalCard) {
        medicalCardService.addMedicalCardInDB(medicalCard);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/medical-card/{id}")
    public ResponseEntity<String> deleteMedicalCardInDB(@PathVariable long id) {
        medicalCardService.deleteMedicalCardInDB(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}
