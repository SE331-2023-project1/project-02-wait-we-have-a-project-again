package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.HistoryComment;

import java.util.List;

public interface HistoryCommentRepository extends JpaRepository<HistoryComment, Long> {
    List<HistoryComment> findAll();
    Page<HistoryComment> findByStudentIdContainingOrAdvisorId(Long studentId, Long advisorId, Pageable pageReq);
}
