package com.example.bookinfoservice.repository;
import com.example.bookinfoservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    User getUserByUserName(String username);
    User getUserByUserId(Integer id);
}
