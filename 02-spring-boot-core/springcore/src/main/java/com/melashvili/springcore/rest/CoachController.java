package com.melashvili.springcore.rest;

import com.melashvili.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
    private Coach myCoach;
//    private Coach secondCoach;

    @Autowired
    public CoachController(
            @Qualifier("aquatic") Coach coach){
        this.myCoach = coach;
    }

    @GetMapping("/sports")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/checker")
//    public boolean check(){
//        return myCoach == secondCoach;
//    }
}
