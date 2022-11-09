package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.Signal;
import liga.medical.personservice.core.repository.SignalRepository;
import liga.medical.personservice.core.service.SignalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignalServiceImpl implements SignalService {

    private final SignalRepository signalRepository;

    @Override
    public List<Signal> getAllSignals() {
        List<Signal> listSignal = new ArrayList<>();
        signalRepository.findAll().forEach(listSignal::add);
        return listSignal;
    }

    @Override
    public Signal getSignalById(long id) {
        return signalRepository.findById(id).get();
    }

    @Override
    public Signal saveSignal(Signal signal) {
        return signalRepository.save(signal);
    }

    @Override
    public void deleteSignalById(long id) {
        signalRepository.deleteById(id);
    }
}
