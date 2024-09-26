package com.melashvili.imagemappingchecker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RequestController {

    @Value("${response.app.api}")
    private String api;

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostMapping("/saveImage")
    public Response saveImage(@RequestBody Request request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Request> requestHttpEntity = new HttpEntity<>(request, headers);

        Response response = restTemplate().exchange(
                api,
                HttpMethod.POST,
                requestHttpEntity,
                Response.class
        ).getBody();

        return response;
    }
}
