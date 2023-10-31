package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.lab.rest.security.user.User;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String studentID;
    String name;
    String surname;
    String department;
    //student ID, name, surname, profile image, and department.
    @ManyToOne
    Advisor advisor;
    @ElementCollection
    List<String> image;
    @OneToOne
    User user;

    public Student(String studentID, String name, String surname, String department) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.advisor = new Advisor();
    }

}
