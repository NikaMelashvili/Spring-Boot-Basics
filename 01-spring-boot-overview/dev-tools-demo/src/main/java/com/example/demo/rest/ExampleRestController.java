package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indicates this is a restful controller
public class ExampleRestController {
    @Value("${coach.value}")
    String coach;
    @Value("${team.value}")
    String team;
    @Value("${text.value}")
    String textToOutput = "Hello world!"; //hello world is default if text.value doesn't work or sum like that.

    @GetMapping("/") //in this situation endpoint is / we can change it
    public String sayHello(){
        return textToOutput;
    }

    @GetMapping("/workout")
    public String dailyWorkout(){
        return "Never back down never give up!";
    }

    @GetMapping("/football")
    public String barca(){
        return "coach of " + team + " is " + coach;
    }
    //with devtools dependency we inject new content and it automatically adds it to the project. we inserted the endpoint
    // /workout while the app was running and in was added without a reload.
}
