package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.mapping.LogMapper;
import liga.medical.personservice.core.dto.model.LogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogMapper logMapper;

    public void addLogInDB(LogDTO logDTO) {
        logMapper.addLogsInDB(logDTO);
    }
}
