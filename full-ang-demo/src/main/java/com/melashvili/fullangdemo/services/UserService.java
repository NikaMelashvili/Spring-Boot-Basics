package com.melashvili.fullangdemo.services;

import com.melashvili.fullangdemo.model.dto.AddUserDTO;
import com.melashvili.fullangdemo.model.entitites.User;
import com.melashvili.fullangdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser (AddUserDTO dto) {
        User user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);
    }
}
