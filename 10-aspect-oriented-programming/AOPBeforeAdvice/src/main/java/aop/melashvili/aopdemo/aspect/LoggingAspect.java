package aop.melashvili.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* add* (aop.melashvili.aopdemo.Account, ..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void log(){
        System.out.println("This is a Before logger");
    }
}
