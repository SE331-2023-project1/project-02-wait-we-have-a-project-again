package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Advisor;

import java.util.List;

public interface AdvisorService {
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getEvent(Long id);
    Advisor getAdvisorById (Long id);
    Advisor save(Advisor advisor);
}
