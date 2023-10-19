package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
