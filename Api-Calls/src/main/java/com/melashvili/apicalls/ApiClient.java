package com.melashvili.apicalls;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiClient {

    private final RestTemplate restTemplate;

    public ApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> getUsers() {
        User[] users = restTemplate.getForObject(ApiUtils.USER_API, User[].class);
        return Arrays.asList(users);
    }

    public User getUserById(Integer id) {
        String url = ApiUtils.USER_API + "/" + id;
        return restTemplate.getForObject(url, User.class);
    }
}
