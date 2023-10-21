package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.StudentDao;
import se331.lab.rest.entity.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
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
    public Student save(Student student){
        return studentDao.save(student);
    }
}
