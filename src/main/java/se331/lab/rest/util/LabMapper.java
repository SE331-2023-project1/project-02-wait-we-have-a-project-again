package se331.lab.rest.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab.rest.dto.*;
import se331.lab.rest.entity.Advisor;
import se331.lab.rest.entity.HistoryComment;
import se331.lab.rest.entity.Student;
import se331.lab.rest.dto.CommentDTO;
import se331.lab.rest.entity.Comment;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDto(Student student);
    List<StudentDTO> getStudentDto(List<Student> students);
    AdvisorDTO getAdvisorDto(Advisor advisor);
    List<AdvisorDTO> getAdvisorDto(List<Advisor> advisors);
    OwnsAdvisorDTO getAdvisorForStudent(Advisor advisor);
    OwnStudentDTO getStudentForAdvisor(Student student);
    @Mapping(target ="roles",source = "user.roles")
    @Mapping(target = "studentList", source = "advisor.studentList")
    AdvisorAuthDTO getAdvisorAuthDTO(Advisor advisor);
    @Mapping(target ="roles",source = "user.roles")
    StudentAuthDTO getStudentAuthDTO(Student student);
    CommentDTO getCommentDTO (Comment comment);
    List<CommentDTO> getCommentDTO (List<Comment> commentList);
    HistoryCommentDTO getHistoryCommentDTO(HistoryComment historyComment);
    List<HistoryCommentDTO> getHistoryCommentDTO(List<HistoryComment> historyComments);


}
