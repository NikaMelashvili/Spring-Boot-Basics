package com.melashvili.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //this annotation marks the class as a spring bean and makes it available for dependency injection
//@Primary //this would be primary if tennis didnt have the @Qualifier
//@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FootballCoach implements Coach{
    public FootballCoach(){
        System.out.println("In constructor " + getClass().getSimpleName());
    }

//    @PostConstruct
//    public void initialization(){
//        System.out.println("initialization " + getClass().getSimpleName());
//    }
//    @PreDestroy
//    public void destroy(){
//        System.out.println("destroy " + getClass().getSimpleName());
//    }
    @Override
    public String getDailyWorkout() {
        return "I'm the football coach";
    }
}
