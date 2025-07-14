package com.program.webspringboot.service;

import com.program.webspringboot.dto.UserDTO;
import com.program.webspringboot.entities.User;
import com.program.webspringboot.repositories.UserReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserReposiroty userReposiroty;

    public User findById(Long id) {
        Optional<User> user = userReposiroty.findById(id);
        return user.get();
    }

    public List<User> findAll() {
        return userReposiroty.findAll();
    }

    public UserDTO insert(UserDTO userDTO) {
        User userEntity = new User();
        userEntity.setId(null);
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity.setPassword(userDTO.getPassword());

        userEntity = userReposiroty.save(userEntity);

        return new UserDTO(userEntity);
    }

    public void delete(Long id) {
        userReposiroty.deleteById(id);
    }

    public UserDTO update(Long id, UserDTO userDTO) {
        User userEntity = userReposiroty.getReferenceById(id);
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPhone(userDTO.getPhone());
        userEntity = userReposiroty.save(userEntity);
        return new UserDTO(userEntity);
    }

}
