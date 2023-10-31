package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Student;
import se331.lab.rest.service.AdvisorService;
import se331.lab.rest.util.LabMapper;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class AdvisorController {
    final AdvisorService advisorService;

    @GetMapping("advisors")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page,
                                             @RequestParam(value = "title",required = false) String title) {
        perPage = perPage == null ? 6 : perPage;
        page = page == null ? 1 : page;
        Page<Advisor> pageOutput;
        if(title == null){
            pageOutput  = advisorService.getAdvisors(perPage, page);
        }else {
            pageOutput = advisorService.getAdvisor(title, PageRequest.of(page-1, perPage));
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAdvisorDto(pageOutput.getContent()),responseHeaders,HttpStatus.OK);
    }
    @GetMapping("advisors/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id")Long id){
        Advisor output = advisorService.getEvent(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDto(output));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the given id is not found");
        }
    }

    @PostMapping("/advisors")
    public ResponseEntity<?> addAdvisor(@RequestBody Advisor advisor){
        Advisor output = advisorService.save(advisor);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDto(output));
    }
    @PutMapping("/advisors/{id}")
    public ResponseEntity<?> updateAdvisor(@PathVariable("id") Long id, @RequestBody Advisor updateAdvisor) {
        Advisor existingAdvisor = advisorService.getEvent(id);
        if (existingAdvisor != null) {
            if (updateAdvisor.getName() != null) {
                existingAdvisor.setName(updateAdvisor.getName());
            }
            if (updateAdvisor.getSurname() != null) {
                existingAdvisor.setSurname(updateAdvisor.getSurname());
            }
            if (updateAdvisor.getDepartment() != null) {
                existingAdvisor.setDepartment(updateAdvisor.getDepartment());
            }
            if (updateAdvisor.getSurname() != null) {
                existingAdvisor.setSurname(updateAdvisor.getSurname());
            }
            if (updateAdvisor.getPosition() != null) {
                existingAdvisor.setPosition(updateAdvisor.getPosition());
            }
            if (updateAdvisor.getAnnouncements() != null) {
                existingAdvisor.setAnnouncements(updateAdvisor.getAnnouncements());
            }
            Advisor output = advisorService.save(existingAdvisor);
            return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}