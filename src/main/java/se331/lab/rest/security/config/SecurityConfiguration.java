package se331.lab.rest.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.headers((headers) -> {
      headers.frameOptions((frameOptions) -> frameOptions.disable());
    });
    http
            .csrf((crsf) -> crsf.disable())
            .authorizeHttpRequests((authorize) -> {
                authorize.requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/students").permitAll()
                        .requestMatchers(HttpMethod.GET, "/advisors").permitAll()
                        .requestMatchers(HttpMethod.GET, "/advisors/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/students/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/history/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/comments/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/history/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/comments/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/students/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/advisors/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/advisors").permitAll()
                        .requestMatchers(HttpMethod.POST, "/announcements").permitAll()
                        .requestMatchers(HttpMethod.GET, "/announcements").permitAll()
                        .requestMatchers(HttpMethod.POST, "/uploadImage").permitAll()
                        .requestMatchers(HttpMethod.POST, "/uploadFile").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .anyRequest().authenticated();
            })

            .sessionManagement((session) ->{
              session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            })


            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout((logout) -> {
              logout.logoutUrl("/api/v1/auth/logout");
              logout.addLogoutHandler(logoutHandler);
              logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
            })
    ;
    http.cors(withDefaults());

    return http.build();

  }
}
