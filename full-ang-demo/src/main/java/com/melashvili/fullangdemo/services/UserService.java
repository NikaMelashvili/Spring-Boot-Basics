package com.melashvili.fullangdemo.services;

import com.melashvili.fullangdemo.model.dto.AddUserDTO;
import com.melashvili.fullangdemo.model.dto.GetUserDTO;
import com.melashvili.fullangdemo.model.entitites.User;
import com.melashvili.fullangdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public GetUserDTO getUser (Long id) {
        User user = userRepository.getReferenceById(id);

        GetUserDTO dto = new GetUserDTO();

        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());

        return dto;
    }

    public void updateUser (AddUserDTO dto, Long id) {
        User user = userRepository.getReferenceById(id);

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.getReferenceById(id);
    }

    public List<GetUserDTO> getAllUsers() {
        List<User> dtos = userRepository.findAll();
        List<GetUserDTO> dtoList = new ArrayList<>();

        for (User user : dtos) {
            GetUserDTO dto = new GetUserDTO();

            dto.setId(user.getId());
            dto.setEmail(user.getEmail());
            dto.setPassword(user.getPassword());

            dtoList.add(dto);
        }
        return dtoList;
    }
}
