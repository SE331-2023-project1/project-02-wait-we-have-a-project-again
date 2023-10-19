package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.repository.AdvisorRepository;

@Repository
@RequiredArgsConstructor
public class AdvisorDaoImpl implements AdvisorDao{
    final AdvisorRepository advisorRepository;
    @Override
    public Integer getAdvisorSize(){
        return Math.toIntExact(advisorRepository.count());
    }
    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page){
        long totalEvents =advisorRepository.count();
        pageSize = pageSize == null ? (int) totalEvents : pageSize;
        page = page == null ? 0 : page - 1;
        return advisorRepository.findAll(PageRequest.of(page, pageSize));
    }
    @Override
    public Advisor getAdvisor(Long id){
        return advisorRepository.findById(id).orElse(null);
    }
    @Override
    public Advisor save(Advisor advisor){
        return advisorRepository.save(advisor);
    }

}
