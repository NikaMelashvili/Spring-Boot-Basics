package com.melashvili.imageresponder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class ResponseController {

    @PostMapping("/res")
    public Response call(@RequestBody Request request){
        if (request.getImage() != null){
            Response response = new Response();

            response.setMessage("Image received successfully");

            return response;
        }
        return null;
    }
}
