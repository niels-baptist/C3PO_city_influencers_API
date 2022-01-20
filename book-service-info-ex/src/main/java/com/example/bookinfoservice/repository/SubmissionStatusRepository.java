package com.example.bookinfoservice.repository;

import com.example.bookinfoservice.model.SubmissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionStatusRepository extends JpaRepository<SubmissionStatus, Integer> {
}