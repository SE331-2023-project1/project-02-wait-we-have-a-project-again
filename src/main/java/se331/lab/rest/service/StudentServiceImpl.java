package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Student;

public interface StudentService {
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
    Student save(Student student);
}
