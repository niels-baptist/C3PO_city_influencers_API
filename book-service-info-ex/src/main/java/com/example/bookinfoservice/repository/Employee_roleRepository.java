package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.Employee;
import com.example.bookinfoservice.model.Employee_role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Employee_roleRepository extends JpaRepository<Employee_role, Integer> {
    List<Employee_role> findAll();
}
