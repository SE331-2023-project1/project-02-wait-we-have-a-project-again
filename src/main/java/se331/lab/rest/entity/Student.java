package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;

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
    String image;
    String department;
    //student ID, name, surname, profile image, and department.
    @ManyToOne
    Advisor advisor;
}
