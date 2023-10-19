package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.AdvisorRepository;
import se331.lab.rest.repository.StudentRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AdvisorRepository advisorRepository;
    final StudentRepository studentRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        Advisor advisor1,advisor2;
        advisor1 = advisorRepository.save(Advisor
                .builder()
                .name("Somsak")
                .surname("Smith")
                .department("English language teaching")
                .position("Lecturer")
                .build());
        advisor2 = advisorRepository.save(Advisor.builder()
                .name("Ahmed")
                .surname("Khan")
                .department("Business Administration")
                .position("Researcher")
                .build());
        Student student;
        student = studentRepository.save(Student.builder()
                .studentID("S001")
                .name("John")
                .surname("Doe")
                .department("Computer Science")
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S002")
                .name("Jane")
                .surname("Smith")
                .department("Mathematics")
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S003")
                .name("Alice")
                .surname("Johnson")
                .department("Physics")
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S004")
                .name("Bob")
                .surname("Brown")
                .department("Chemistry")
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);







    }
}
