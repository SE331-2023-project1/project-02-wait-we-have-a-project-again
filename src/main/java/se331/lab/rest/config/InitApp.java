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
        Advisor advisor1,advisor2,advisor3,advisor4,advisor5,advisor6;
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
        advisor3 = advisorRepository.save(Advisor.builder()
                .name("John")
                .surname("Doe")
                .department("Mathematics")
                .position("Professor")
                .build());

        advisor4 = advisorRepository.save(Advisor.builder()
                .name("Alice")
                .surname("Johnson")
                .department("History")
                .position("Associate Professor")
                .build());

        advisor5 = advisorRepository.save(Advisor.builder()
                .name("Ella")
                .surname("Smith")
                .department("Physics")
                .position("Assistant Professor")
                .build());
        advisor6 = advisorRepository.save(Advisor.builder()
                .name("David")
                .surname("Lee")
                .department("Computer Science")
                .position("Professor")
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

        student = studentRepository.save(Student.builder()
                .studentID("S005")
                .name("Grace")
                .surname("Adams")
                .department("English")
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S006")
                .name("Henry")
                .surname("Wilson")
                .department("Engineering")
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S007")
                .name("Isabella")
                .surname("Harris")
                .department("Geology")
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S008")
                .name("Jane")
                .surname("Lee")
                .department("Psychology")
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S009")
                .name("Jackson")
                .surname("Parker")
                .department("Computer Science")
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S010")
                .name("Sandra")
                .surname("Bullock")
                .department("Biology")
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S011")
                .name("Denzel")
                .surname("Washington")
                .department("Mathematics")
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S012")
                .name("Jennifer")
                .surname("Kim")
                .department("History")
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S013")
                .name("Mika")
                .surname("Donald")
                .department("Social")
                .build());
        student.setAdvisor(advisor1);
        advisor1.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S014")
                .name("Silver")
                .surname("Morgan")
                .department("Geology")
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S015")
                .name("Casper")
                .surname("Miller")
                .department("Music")
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S016")
                .name("Sparkle")
                .surname("Evans")
                .department("Biology")
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S017")
                .name("Rose")
                .surname("Lopez")
                .department("Biology")
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S018")
                .name("Sparkle")
                .surname("Evans")
                .department("Biology")
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);





    }
}
