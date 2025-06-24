package org.scoula.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.scoula.dto.MessageDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Log4j2
@Component
public class LogAdvice {

    @Before("execution(* org.scoula.service.MessageService*.sendMessage(dto)) && args(dto)")
    public void logBeforeWithParam(MessageDTO dto) {
        log.info("[Before] 전달된 파라미터: " + dto);
    }

    @Around("execution(* org.scoula.service.messageService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();

        log.info("Target: " + pjp.getTarget());
        log.info("Param: " + Arrays.toString(pjp.getArgs()));

        Object result = null;
        try {
            result = pjp.proceed(); // 실제 메서드 호출
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        log.info("TIME: " + (end - start));

        return result;
    }
}
