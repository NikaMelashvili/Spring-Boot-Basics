package com.melashvili.springcore.common;

import org.springframework.web.bind.annotation.RestController;

public class SwimCoach implements Coach{
    public SwimCoach (){
        System.out.println("SwimCoach in constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "I'm the swimming coach";
    }
}
