package com.program.webspringboot.service;

import com.program.webspringboot.entities.User;
import com.program.webspringboot.repositories.UserReposiroty;
import com.program.webspringboot.service.exceptions.DataBaseException;
import com.program.webspringboot.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserReposiroty userReposiroty;

    public List<User> findAll() {
        return userReposiroty.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userReposiroty.findById(id);
        return user.orElseThrow(() -> {
            throw new ResourceNotFoundException("User not found with id " + id);
        });
    }

    public User insert(User user) {
        User userEntity = userReposiroty.save(user);
        return userEntity;
    }

    public User update(Long id, User user) {
        try {
            User userEntity = userReposiroty.getReferenceById(id);
            userEntity.setName(user.getName());
            userEntity.setEmail(user.getEmail());
            userEntity.setPhone(user.getPhone());
            userEntity = userReposiroty.save(userEntity);
            return userEntity;
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }

    public void delete(Long id) {
        Optional<User> user = userReposiroty.findById(id);
        try {
            if (user.isPresent()) userReposiroty.deleteById(id);
            else throw new ResourceNotFoundException("User not found with id " + id);
        }
        catch (DataIntegrityViolationException err) {
            throw new DataBaseException(err.getMessage());
        }
    }

}
