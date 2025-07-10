package com.program.webspringboot.repositories;

import com.program.webspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposiroty extends JpaRepository<User, Long> {
}
