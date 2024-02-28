package aop.melashvili.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


// if we have only pointcut expressions @Aspect annotation is optional
@Aspect
public class AopExpressions {

    @Pointcut("execution(* aop.melashvili.aopdemo.aspect.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* aop.melashvili.aopdemo.aspect.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* aop.melashvili.aopdemo.aspect.*.set*(..))")
    public void setter() {}

    // create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
