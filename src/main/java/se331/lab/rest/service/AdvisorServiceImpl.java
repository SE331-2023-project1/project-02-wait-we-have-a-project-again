package se331.lab.rest.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AdvisorDao;
import se331.lab.rest.entity.Advisor;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService {
    final AdvisorDao advisorDao;
    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page){
        return advisorDao.getAdvisors(pageSize,page);
    }
    @Override
    public Advisor getEvent(Long id){
        return advisorDao.getAdvisor(id);
    }
    @Override
    public Advisor save(Advisor advisor){
        return advisorDao.save(advisor);
    }
}
