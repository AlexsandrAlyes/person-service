package liga.medical.personservice.core.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.personservice.core.annotations.DbLog;
import liga.medical.personservice.core.dto.entity.Exception;
import liga.medical.personservice.core.dto.entity.PersonData;
import liga.medical.personservice.core.dto.entity.Signal;
import liga.medical.personservice.core.dto.model.MessageDTO;
import liga.medical.personservice.core.service.ExceptionService;
import liga.medical.personservice.core.service.PersonDataService;
import liga.medical.personservice.core.service.SignalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitMessageListener {

    private final SignalService signalService;
    private final PersonDataService personDataService;
    private final ExceptionService exceptionService;

    private final ObjectMapper mapper = new ObjectMapper();

    @DbLog
    @RabbitListener(queues = "daily_queue")
    public void getMessagesFromQueueDaily(String message) throws JsonProcessingException, SQLException {
        MessageDTO messageDTO = mapper.readValue(message, MessageDTO.class);
        Signal signal = new Signal();
        PersonData personData = new PersonData();
        try {
            personData = personDataService.getPersonDataById(messageDTO.getId());
        } catch (NoSuchElementException e) {
            log.error("liga.medical.personservice.core.listener.getMessagesFromQueueDaily: " + e.getMessage());
            Exception exception = new Exception();
            exception.setSystemTypeId("ERROR");
            exception.setMethodParams("liga.medical.personservice.core.listener.getMessagesFromQueueDaily:" +
                    "В сообщение типа daily содержало неверны id для PersonData");
            exceptionService.saveExceptionInDB(exception);
            return;
        }

        signal.setPersonData(personData);
        signal.setType(messageDTO.getType().name());
        signal.setDescription("liga.medical.personservice.core.listener.getMessagesFromQueueDaily: " + message);
        signalService.saveSignal(signal);

    }

    @DbLog
    @RabbitListener(queues = "alert_queue")
    public void getMessagesFromQueueAlert(String message) throws JsonProcessingException {
        MessageDTO messageDTO = mapper.readValue(message, MessageDTO.class);
        Signal signal = new Signal();
        PersonData personData = new PersonData();
        try {
            personData = personDataService.getPersonDataById(messageDTO.getId());
        } catch (NoSuchElementException e) {
            log.error("liga.medical.personservice.core.listener.getMessagesFromQueueAlert: " + e.getMessage());
            Exception exception = new Exception();
            exception.setSystemTypeId("ERROR");
            exception.setMethodParams("liga.medical.personservice.core.listener.getMessagesFromQueueAlert:" +
                    "В сообщение типа alert содержало неверны id для PersonData");
            exceptionService.saveExceptionInDB(exception);
            return;

        }

        signal.setPersonData(personData);
        signal.setType(messageDTO.getType().name());
        signal.setDescription("liga.medical.personservice.core.listener.getMessagesFromQueueAlert: " + message);
        signalService.saveSignal(signal);

    }

    @DbLog
    @RabbitListener(queues = "error_queue")
    public void getMessagesFromQueueError(String message) throws JsonProcessingException {
        MessageDTO messageDTO = mapper.readValue(message, MessageDTO.class);
        Signal signal = new Signal();
        PersonData personData = new PersonData();
        try {
            personData = personDataService.getPersonDataById(messageDTO.getId());
        } catch (NoSuchElementException e) {
            log.error("liga.medical.personservice.core.listener.getMessagesFromQueueError: " + e.getMessage());
            Exception exception = new Exception();
            exception.setSystemTypeId("ERROR");
            exception.setMethodParams("liga.medical.personservice.core.listener.getMessagesFromQueueError:" +
                    "В сообщение типа error содержало неверны id для PersonData");
            exceptionService.saveExceptionInDB(exception);
            return;
        }

        signal.setPersonData(personData);
        signal.setType(messageDTO.getType().name());
        signal.setDescription("liga.medical.personservice.core.listener.getMessagesFromQueueError: " + message);
        signalService.saveSignal(signal);

    }
}
