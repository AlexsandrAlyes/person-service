package liga.medical.personservice.core.service.serviceImpl;

import liga.medical.personservice.core.dto.entity.Exception;
import liga.medical.personservice.core.repository.ExceptionRepository;
import liga.medical.personservice.core.service.ExceptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExceptionServiceImpl implements ExceptionService {

    private final ExceptionRepository exceptionRepository;

    @Override
    public Exception saveExceptionInDB(Exception exception) {
        return exceptionRepository.save(exception);
    }
}
