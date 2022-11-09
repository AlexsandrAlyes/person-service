package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.entity.Signal;

import java.util.List;

public interface SignalService {

    List<Signal> getAllSignals();

    Signal getSignalById(long id);

    Signal saveSignal(Signal signal);

    void deleteSignalById(long id);
}
