package aop.melashvili.aopdemo.aspect;

import aop.melashvili.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Before("aop.melashvili.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(signature);

        Object[] args = joinPoint.getArgs();

        for (Object temp : args){
            System.out.println(temp);

            if(temp instanceof Account){
                Account account = (Account) temp;
                System.out.println(account.getName());
                System.out.println(account.getLevel());
            }
        }
    }
}
