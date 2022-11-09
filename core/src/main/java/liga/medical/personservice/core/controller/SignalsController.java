package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.dto.entity.Signal;
import liga.medical.personservice.core.service.SignalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/db")
@Api(value = "Api по работе с signals")
public class SignalsController {

    private final SignalService signalService;

    @GetMapping("/signal")
    @ApiOperation(value = "Получение всех сигналов")
    public List<Signal> getAllSignal() {
        return signalService.getAllSignals();
    }

    @GetMapping("/signal/{id}")
    @ApiOperation(value = "Получение сигнал по id")
    public Signal getSignalById(@PathVariable long id) {
        return signalService.getSignalById(id);
    }

    @PostMapping("/siganl")
    @ApiOperation(value = "Добавление нового сигнала")
    public ResponseEntity<String> addsignalInDB(@RequestBody Signal signal) {
        signalService.saveSignal(signal);
        return ResponseEntity.ok("Данные были успешно добавлены");
    }

    @DeleteMapping("/signal/{id}")
    @ApiOperation(value = "Удаление сигнала по id")
    public ResponseEntity<String> deleteSignalInDB(@PathVariable long id) {
        signalService.deleteSignalById(id);
        return ResponseEntity.ok("Данные были успешно удалены");
    }
}
