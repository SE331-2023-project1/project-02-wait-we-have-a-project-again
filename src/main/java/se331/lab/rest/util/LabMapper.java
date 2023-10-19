package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.dto.AdvisorDTO;
import se331.lab.rest.dto.StudentDTO;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.Student;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    AdvisorDTO getAdvisorDto(Advisor advisor);
    List<AdvisorDTO> getAdvisorDto(List<Advisor> advisors);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDto(List<Student> students);


}
