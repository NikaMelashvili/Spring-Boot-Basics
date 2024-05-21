package com.melashvili.apicalls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ApiClient apiClient;

    @Autowired
    public ApiController(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return apiClient.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return apiClient.getUserById(id);
    }
}
