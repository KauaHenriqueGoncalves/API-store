package com.program.webspringboot.service;

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

    public User insert(User user) {
        User userEntity = userReposiroty.save(user);
        return userEntity;
    }

    public void delete(Long id) {
        userReposiroty.deleteById(id);
    }

    public User update(Long id, User user) {
        User userEntity = userReposiroty.getReferenceById(id);
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPhone(user.getPhone());
        userEntity = userReposiroty.save(userEntity);
        return userEntity;
    }

}
