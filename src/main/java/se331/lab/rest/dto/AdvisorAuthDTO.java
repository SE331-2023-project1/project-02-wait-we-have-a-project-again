package se331.lab.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.security.user.Role;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorAuthDTO {
    Long id;
    String name;
    String surname;
    String position;
    List<String> image;
    String advisorID;
    String department;
    List<OwnStudentDTO> studentList = new ArrayList<>();
    List<Role> roles = new ArrayList<>();
}
