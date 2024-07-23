package com.melashvili.fullangdemo.controller;

import com.melashvili.fullangdemo.model.dto.AddUserDTO;
import com.melashvili.fullangdemo.model.dto.GetUserDTO;
import com.melashvili.fullangdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get")
    public ResponseEntity<List<GetUserDTO>> getUsers() {
        List<GetUserDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GetUserDTO> getUserById(@PathVariable Long id) {
        GetUserDTO dto = userService.getUser(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody AddUserDTO dto) {
        userService.updateUser(dto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
