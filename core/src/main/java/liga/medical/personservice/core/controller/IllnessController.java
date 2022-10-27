package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.dto.model.Illness;
import liga.medical.personservice.core.service.IllnessService;
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
public class IllnessController {

    private final IllnessService illnessService;

    @GetMapping("/illness")
    public List<Illness> getAllIllness() {
        return illnessService.getAllIllness();
    }

    @GetMapping("/illness/{id}")
    public Illness geIllnessById(@PathVariable long id) {
        return illnessService.getIllnessById(id);
    }

    @PostMapping("/illness")
    public ResponseEntity<String> addIllnessInDB(@RequestBody Illness illness) {
        illnessService.addIllnessInDB(illness);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/illness/{id}")
    public ResponseEntity<String> deleteIllnessInDB(@PathVariable long id) {
        illnessService.deleteIllnessInDB(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}