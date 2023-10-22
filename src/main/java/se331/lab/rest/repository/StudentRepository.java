package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();

    Page<Student> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrStudentID
            (String name, String surName, String studentID, Pageable PageRequest);
}
