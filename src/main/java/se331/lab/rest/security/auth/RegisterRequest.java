package se331.lab.rest.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String advisorID;
  private String studentID;
  private String name;
  private String surname;
  private String username;
  private String email;
  private String password;
}
