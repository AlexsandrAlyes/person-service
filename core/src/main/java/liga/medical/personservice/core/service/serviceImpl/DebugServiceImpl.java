package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.Debug;
import liga.medical.personservice.core.repository.DebugRepository;
import liga.medical.personservice.core.service.DebugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebugServiceImpl implements DebugService {

    private final DebugRepository debugRepository;

    @Override
    public Debug saveDebugInDB(Debug debug) {
        return debugRepository.save(debug);
    }
}
