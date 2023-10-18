package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.repository.AdvisorRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AdvisorRepository advisorRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent){
        advisorRepository.save(Advisor.builder()
                        .name("Somsak")
                        .surname("Smith")
                        .department("English language teaching")
                        .position("Lecturer")
                        .build());
        advisorRepository.save(Advisor.builder()
                         .name("Ahmed")
                         .surname("Khan")
                         .department("Business Administration")
                         .position("Researcher")
                         .build());
    }
}
