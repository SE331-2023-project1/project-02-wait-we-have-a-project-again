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
public class HistoryComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    @OneToMany(mappedBy = "history")
    @Builder.Default
    List<Comment> commentHistory = new ArrayList<>();
    Long studentId;
    Long advisorId;
}
