package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {

}
