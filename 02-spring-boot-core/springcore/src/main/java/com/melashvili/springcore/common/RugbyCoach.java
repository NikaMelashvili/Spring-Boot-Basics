package com.melashvili.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class RugbyCoach implements Coach{
    public RugbyCoach(){
        System.out.println("In constructor " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "I'm the rugby coach";
    }
}
