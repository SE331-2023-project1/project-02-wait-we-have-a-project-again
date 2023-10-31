package se331.lab.rest.entity;

import jakarta.persistence.*;
import lombok.*;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    @ManyToOne
    HistoryComment history;
    String text;
    Boolean sentByAdvisor;

}
