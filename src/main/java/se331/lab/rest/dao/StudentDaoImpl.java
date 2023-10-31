package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.StudentRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoImpl implements StudentDao{

    final StudentRepository studentRepository;
    @Override
    public Integer getStudentSize(){
        return Math.toIntExact(studentRepository.count());
    }
    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page){
        long totalEvents =studentRepository.count();
        pageSize = pageSize == null ? (int) totalEvents : pageSize;
        page = page == null ? 0 : page - 1;
        return studentRepository.findAll(PageRequest.of(page, pageSize));
    }
    @Override
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }
    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudent(String name, Pageable page) {
        return studentRepository.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCaseOrStudentID
                (name, name, name, page);
    }
    @Override
    public Page<Student> getAdvisor(Pageable pageRequest){
        return studentRepository.findAll(pageRequest);
    }
}
