package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
