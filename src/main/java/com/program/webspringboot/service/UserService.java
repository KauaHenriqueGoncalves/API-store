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

}
