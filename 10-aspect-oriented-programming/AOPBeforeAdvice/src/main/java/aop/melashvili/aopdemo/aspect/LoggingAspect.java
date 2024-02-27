package aop.melashvili.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* add* (aop.melashvili.aopdemo.Account))")
    public void log(){
        System.out.println("This is a Before logger");
    }
}