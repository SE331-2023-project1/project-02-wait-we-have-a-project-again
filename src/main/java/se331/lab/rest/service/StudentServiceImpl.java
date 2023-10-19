package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.StudentDao;
import se331.lab.rest.entity.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        return studentDao.getEStudents(pageSize,page);
    }
    @Override
    public Student getStudent(Long id){
        return studentDao.getStudent(id);
    }
    @Override
    public Student save(Student student){
        return studentDao.save(student);
    }
}
