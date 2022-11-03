package liga.medical.personservice.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.personservice.core.dto.model.LogDTO;
import liga.medical.personservice.core.service.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoggingAdvice {

    private final LogService logService;

    @Pointcut("@annotation(liga.medical.personservice.core.annotations.Loggable)")
    public void loggableMethods() {
    }

    @Pointcut("execution(* liga.medical.personservice.core.controller.*.*(..))" +
            "&& !execution(* liga.medical.personservice.core.controller.SecurityController.*(..))")
    public void allMethodsPackageControllerExceptSecurityController() {
    }

    @Around("allMethodsPackageControllerExceptSecurityController()")
    public Object applicationLogger(ProceedingJoinPoint joinPoint) throws JsonProcessingException {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        ObjectMapper mapper = new ObjectMapper();

        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        Object[] array = joinPoint.getArgs();

        log.info("Вызван метод : " + className + ":" + methodName + "с аргументами" + mapper.writeValueAsString(array) +
                ": имя пользователя: " + username);

        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        log.info(className + ":" + methodName + "() " + "Response: " + mapper.writeValueAsString(obj) +
                ": имя пользователя: " + username);
        return obj;
    }

    @Around("loggableMethods()")
    public Object securityLooger(ProceedingJoinPoint joinPoint) throws JsonProcessingException {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        ObjectMapper mapper = new ObjectMapper();

        String className = joinPoint.getTarget().getClass().toString();
        String methodName = joinPoint.getSignature().getName();
        Object[] array = joinPoint.getArgs();

        log.info("Вызван метод : " + className + ":" + methodName + "с аргументами" + mapper.writeValueAsString(array) +
                ": имя пользователя: " + username);

        logService.addLogInDB(new LogDTO(LocalDateTime.now(),
                "INFO",
                log.getName() + "." + methodName,
                "Вызван метод : " + className + ":" + methodName + "с аргументами" +
                        mapper.writeValueAsString(array),
                username)
        );
        Object obj = null;

        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info(className + ":" + methodName + "() " + "Response: " + mapper.writeValueAsString(obj) +
                ": имя пользователя: " + username);

        logService.addLogInDB(new LogDTO(LocalDateTime.now(),
                "INFO",
                log.getName() + "." + methodName,
                className + ":" + methodName + "Response: " +
                        mapper.writeValueAsString(obj),
                username)
        );

        return obj;
    }
}

