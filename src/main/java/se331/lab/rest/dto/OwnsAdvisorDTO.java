package se331.lab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
