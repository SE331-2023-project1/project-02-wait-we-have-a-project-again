package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.lab.rest.security.user.User;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String advisorID;
    String name;
    String surname;
    String position;
    @ElementCollection
    List<String> image;
    String department;
    //adviser information, including academic position, name, surname, profile images, and department.
    @OneToMany
    @Builder.Default
    List<Student> studentList = new ArrayList<>();
    @OneToOne
    User user;

}
