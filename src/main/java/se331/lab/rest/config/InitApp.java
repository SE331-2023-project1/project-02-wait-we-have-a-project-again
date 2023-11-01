package se331.lab.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Comment;
import se331.lab.rest.entity.HistoryComment;
import se331.lab.rest.entity.Student;
import se331.lab.rest.repository.AdvisorRepository;
import se331.lab.rest.repository.CommentRepository;
import se331.lab.rest.repository.HistoryCommentRepository;
import se331.lab.rest.repository.StudentRepository;
import se331.lab.rest.security.user.Role;
import se331.lab.rest.security.user.User;
import se331.lab.rest.security.user.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AdvisorRepository advisorRepository;
    final StudentRepository studentRepository;
    final UserRepository userRepository;
    final HistoryCommentRepository historyCommentRepository;
    final CommentRepository commentRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){

        Advisor advisor1,advisor2,advisor3,advisor4,advisor5,advisor6;
        HistoryComment hist1;
        Comment c1, c2, c3;
        advisor1 = advisorRepository.save(Advisor
                .builder()
                .name("Somsak")
                .surname("Smith")
                .department("English")
                .position("Lecturer")
                .advisorID("A001")
                .image(List.of("https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        advisor2 = advisorRepository.save(Advisor.builder()
                .name("Ahmed")
                .surname("Khan")
                .department("Business Administration")
                .position("Researcher")
                .advisorID("A002")
                .image(List.of("https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .announcements(List.of("https://miro.medium.com/v2/resize:fit:900/1*v4RzJC1ufpxcQWOOhBitPA.jpeg","https://storage.googleapis.com/download/storage/v1/b/projectstorage-165a3.appspot.com/o/2023-10-29%20233234164-953321_721.pdf?generation=1698597162648926&alt=media"))
                .build());
        advisor3 = advisorRepository.save(Advisor.builder()
                .name("Astor   ")
                .surname("Hawk")
                .department("Mathematics")
                .position("Professor")
                .advisorID("A003")
                .image(List.of("https://images.pexels.com/photos/2182970/pexels-photo-2182970.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());

        advisor4 = advisorRepository.save(Advisor.builder()
                .name("Alice")
                .surname("Johnson")
                .department("History")
                .position("Associate Professor")
                .advisorID("A004")
                .image(List.of("https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());

        advisor5 = advisorRepository.save(Advisor.builder()
                .name("Kathy")
                .surname("Merton")
                .department("Physics")
                .position("Assistant Professor")
                .advisorID("A005")
                .image(List.of("https://images.pexels.com/photos/18666051/pexels-photo-18666051.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        advisor6 = advisorRepository.save(Advisor.builder()
                .name("David")
                .surname("Lee")
                .department("Computer Science")
                .position("Professor")
                .advisorID("A006")
                .image(List.of("https://images.pexels.com/photos/1752126/pexels-photo-1752126.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());

        Student student,student1,student2,student3;
        student3 = studentRepository.save(Student.builder()
                .studentID("S001")
                .name("Daisy")
                .surname("Walsh")
                .department("Computer Science")
                .image(List.of("https://images.pexels.com/photos/18678398/pexels-photo-18678398.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student3.setAdvisor(advisor2);
        advisor2.getStudentList().add(student3);


        student1 = studentRepository.save(Student.builder()
                .studentID("S002")
                .name("Jerry")
                .surname("Perry")
                .department("Mathematics")
                .image(List.of("https://images.pexels.com/photos/997472/pexels-photo-997472.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student1.setAdvisor(advisor2);
        advisor2.getStudentList().add(student1);

        student2 = studentRepository.save(Student.builder()
                .studentID("S003")
                .name("May")
                .surname("Gates")
                .department("Physics")
                .image(List.of("https://images.pexels.com/photos/18618357/pexels-photo-18618357.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student2.setAdvisor(advisor5);
        advisor5.getStudentList().add(student2);

        student = studentRepository.save(Student.builder()
                .studentID("S004")
                .name("Bob")
                .surname("Brown")
                .department("Chemistry")
                .image(List.of("https://images.pexels.com/photos/18619767/pexels-photo-18619767.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S005")
                .name("Grace")
                .surname("Adams")
                .department("English")
                .image(List.of("https://images.pexels.com/photos/18665105/pexels-photo-18665105.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S006")
                .name("Henry")
                .surname("Wilson")
                .department("Engineering")
                .image(List.of("https://images.pexels.com/photos/18665111/pexels-photo-18665111.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S007")
                .name("Isabella")
                .surname("Harris")
                .department("Geology")
                .image(List.of("https://images.pexels.com/photos/18580991/pexels-photo-18580991.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S008")
                .name("Jane")
                .surname("Lee")
                .department("Psychology")
                .image(List.of("https://images.pexels.com/photos/18641980/pexels-photo-18641980.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S009")
                .name("Jackson")
                .surname("Parker")
                .department("Computer Science")
                .image(List.of("https://images.pexels.com/photos/18593901/pexels-photo-18593901.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S010")
                .name("Sandra")
                .surname("Bullock")
                .department("Biology")
                .image(List.of("https://images.pexels.com/photos/18673327/pexels-photo-18673327.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S011")
                .name("Scooby")
                .surname("Doo")
                .department("Mathematics")
                .image(List.of("https://images.pexels.com/photos/18665098/pexels-photo-18665098.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S012")
                .name("Jennifer")
                .surname("Kim")
                .department("History")
                .image(List.of("https://images.pexels.com/photos/18633036/pexels-photo-18633036.png?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor6);
        advisor6.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S013")
                .name("Mika")
                .surname("Donald")
                .department("Social")
                .image(List.of("https://images.pexels.com/photos/1486064/pexels-photo-1486064.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S014")
                .name("Silver")
                .surname("Morgan")
                .department("Geology")
                .image(List.of("https://images.pexels.com/photos/1405963/pexels-photo-1405963.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor2);
        advisor2.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S015")
                .name("Casper")
                .surname("Miller")
                .department("Music")
                .image(List.of("https://images.pexels.com/photos/1656684/pexels-photo-1656684.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S016")
                .name("Sparkle")
                .surname("Evans")
                .department("Biology")
                .image(List.of("https://images.pexels.com/photos/1036645/pexels-photo-1036645.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor4);
        advisor4.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S017")
                .name("Rose")
                .surname("Lopez")
                .department("Chemistry")
                .image(List.of("https://images.pexels.com/photos/18667692/pexels-photo-18667692.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor5);
        advisor5.getStudentList().add(student);

        student = studentRepository.save(Student.builder()
                .studentID("S018")
                .name("Buzz")
                .surname("Ligthyear")
                .department("Psychology")
                .image(List.of("https://images.pexels.com/photos/18649280/pexels-photo-18649280.jpeg?auto=compress&cs=tinysrgb&w=600"))
                .build());
        student.setAdvisor(advisor3);
        advisor3.getStudentList().add(student);
        addUser();
        //admin
        advisor1.setUser(user1);
        user1.setAdvisor(advisor1);
        //advisor
        advisor2.setUser(user2);
        user2.setAdvisor(advisor2);
        //student
        student.setUser(user3);
        user3.setStudent(student);
        //advisor
        user5.setAdvisor(advisor3);
        advisor3.setUser(user5);

        student1.setUser(user4);
        user4.setStudent(student1);

        student3.setUser(user6);
        user6.setStudent(student3);

        hist1 = historyCommentRepository.save(HistoryComment.builder()
                .studentId(student1.getId())
                .advisorId(advisor2.getId())
                .build());
        c1 = commentRepository.save(Comment.builder()
                .text("Hello World")
                .sentByAdvisor(true)
                .build());
        c1.setHistory(hist1);
        hist1.getCommentHistory().add(c1);
        c2 = commentRepository.save(Comment.builder()
                .text("Hello Prof")
                .sentByAdvisor(false)
                .build());
        c2.setHistory(hist1);
        hist1.getCommentHistory().add(c2);
        c3 = commentRepository.save(Comment.builder()
                .text("Don't do that")
                .sentByAdvisor(true)
                .build());
        c3.setHistory(hist1);
        hist1.getCommentHistory().add(c3);


    }
    User user1,user2,user3,user4,user5,user6;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .name("admin")
                .surname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user2 = User.builder()
                .username("advisor")
                .password(encoder.encode("advisor"))
                .name("advisor")
                .surname("advisor")
                .email("advisor@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("student")
                .password(encoder.encode("student"))
                .name("student")
                .surname("student")
                .email("student@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user4 = User.builder()
                .username("student1")
                .password(encoder.encode("student1"))
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user5 = User.builder()
                .username("advisor1")
                .password(encoder.encode("advisor1"))
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user6 = User.builder()
                .username("student3")
                .password(encoder.encode("student3"))
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();



        user1.getRoles().add(Role.ROLE_ADMIN);
        userRepository.save(user1);

        user2.getRoles().add(Role.ROLE_ADVISOR);
        userRepository.save(user2);

        user3.getRoles().add(Role.ROLE_STUDENT);
        userRepository.save(user3);

        user4.getRoles().add(Role.ROLE_STUDENT);
        userRepository.save(user4);

        user5.getRoles().add(Role.ROLE_ADVISOR);
        userRepository.save(user5);

        user6.getRoles().add(Role.ROLE_STUDENT);
        userRepository.save(user6);
    }
}