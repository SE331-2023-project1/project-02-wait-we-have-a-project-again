package se331.lab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OwnsAdvisorDTO {
    Long id;
    String name;
    String surname;
    String department;
    String position;
    String advisorID;
    List<String> announcements;
}
