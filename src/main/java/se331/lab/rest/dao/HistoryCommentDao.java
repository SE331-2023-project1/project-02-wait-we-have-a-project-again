package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.HistoryComment;

import java.util.Optional;

public interface HistoryCommentDao {
    Page<HistoryComment> getHistoryComment(Pageable pageRequest);
    Optional<HistoryComment> findById(Long id);
    HistoryComment save(HistoryComment comment);

    Page<HistoryComment> getHistoryComments (Long studentId, Long AdvisorId, Pageable pageReq);
}
