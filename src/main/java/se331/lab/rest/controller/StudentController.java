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
import se331.lab.rest.dto.StudentDTO;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Student;
import se331.lab.rest.service.AdvisorService;
import se331.lab.rest.service.StudentService;
import se331.lab.rest.util.LabMapper;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class StudentController {
    final StudentService studentService;
    final AdvisorService advisorService;
    @GetMapping("students")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page,
                                             @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;
        if(title == null){
            pageOutput  = studentService.getStudents(perPage, page);
        } else {
            pageOutput = studentService.getStudent(title, PageRequest.of(page -1, perPage));
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDto(pageOutput.getContent()),responseHeaders, HttpStatus.OK);
    }
    @GetMapping("students/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id")Long id){
       Student output = studentService.getStudentById(id);
        if(output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDto(output));
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "the given id is not found");
        }
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody Student updateStudent) {
        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent != null) {
            if (updateStudent.getName() != null) {
                existingStudent.setName(updateStudent.getName());
            }
            if (updateStudent.getSurname() != null) {
                existingStudent.setSurname(updateStudent.getSurname());
            }
            if (updateStudent.getImage() != null) {
                existingStudent.setImage(updateStudent.getImage());
            }

            // Check if the Student has an updated Advisor
            if (updateStudent.getAdvisor() != null) {
                Advisor updatedAdvisor = advisorService.getAdvisorById(updateStudent.getAdvisor().getId());

                if (updatedAdvisor != null) {
                    // Remove the Student from the existing Advisor's list
                    if (existingStudent.getAdvisor() != null) {
                        existingStudent.getAdvisor().getStudentList().remove(existingStudent);
                    }

                    // Update the Advisor for the Student
                    existingStudent.setAdvisor(updatedAdvisor);
                    updatedAdvisor.getStudentList().add(existingStudent);
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Advisor with the given ID not found.");
                }
            } else {
                // If no Advisor is provided, clear the Advisor for the Student
                existingStudent.setAdvisor(null);
            }

            Student output = studentService.save(existingStudent);
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

}



