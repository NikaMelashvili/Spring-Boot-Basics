package com.melashvili.fullangdemo.controller;

import com.melashvili.fullangdemo.model.dto.AddUserDTO;
import com.melashvili.fullangdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addUser(@RequestBody AddUserDTO dto) {
        userService.saveUser(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
