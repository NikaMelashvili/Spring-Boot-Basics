package com.exam.nikolozmelashvili.aspect;

import com.exam.nikolozmelashvili.services.LogService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final LogService logService;

    @Autowired
    public LoggingAspect(LogService logService) {
        this.logService = logService;
    }

    @Before("@annotation(Loggable)")
    public void logMethodInvocation() {
        logService.logMethodInvocation();
    }

    @AfterReturning("@annotation(Loggable)")
    public void logMethodReturn() {
        logService.logMethodReturn();
    }
}

