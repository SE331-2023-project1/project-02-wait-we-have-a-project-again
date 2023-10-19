package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Student;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getEStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
    Student save(Student student);
}
