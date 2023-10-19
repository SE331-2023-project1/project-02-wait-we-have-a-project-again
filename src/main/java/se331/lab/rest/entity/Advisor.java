package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;

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
    String name;
    String surname;
    String position;
    String image;
    String department;
    //adviser information, including academic position, name, surname, profile images, and department.
    @OneToMany
    @Builder.Default
    List<Student> studentList = new ArrayList<>();

}
