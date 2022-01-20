package com.example.bookinfoservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User getUserByUserId(int userId);
    List<User> findAll();
}
