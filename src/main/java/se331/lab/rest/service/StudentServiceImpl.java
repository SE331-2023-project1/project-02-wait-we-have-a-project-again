package se331.lab.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AdvisorDao;
import se331.lab.rest.dao.StudentDao;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    final AdvisorDao advisorDao;
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        return studentDao.getStudents(pageSize,page);
    }
    @Override
    public Student getStudentById(Long id){
        return studentDao.getStudentById(id);
    }

    @Override
    public Page<Student> getStudent(String name, Pageable pageable){
        return studentDao.getStudent(name, pageable);
    }
    @Override
    @Transactional
    public Student save(Student student) {
        if (student.getId() == null) {
            // If the student's ID is null, it's a new student, so you can create it.
            Advisor advisor = student.getAdvisor();
            if (advisor != null) {
                // Check if the student is not already associated with the advisor
                if (!advisor.getStudentList().contains(student)) {
                    student.setAdvisor(advisor);
                    advisor.getStudentList().add(student);
                }
                // Continue with the save logic
                return studentDao.save(student);
            } else {
                throw new RuntimeException("Advisor not found.");
            }
        } else {
            // If the student's ID is not null, it's an update operation.
            // Perform any update logic you need here.
            // For example, update other attributes of the student.
            // Then, save the updated student entity.
            return studentDao.save(student);
        }
    }

    @Override
    public List<Student> getAllStudent(){
        return studentDao.getAdvisor(Pageable.unpaged()).getContent();
    }
}
