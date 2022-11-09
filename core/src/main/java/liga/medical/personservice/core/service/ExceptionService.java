package liga.medical.personservice.core.service;

import liga.medical.personservice.core.dto.entity.Exception;

public interface ExceptionService {

    Exception saveExceptionInDB(Exception exception);
}
