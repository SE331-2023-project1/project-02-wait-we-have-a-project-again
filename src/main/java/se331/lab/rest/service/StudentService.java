package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Student;

import java.util.List;

public interface StudentService {
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudentById(Long id);
    Page<Student> getStudent(String name, Pageable pageable);
    Student save(Student student);
    List<Student> getAllStudent();
}
