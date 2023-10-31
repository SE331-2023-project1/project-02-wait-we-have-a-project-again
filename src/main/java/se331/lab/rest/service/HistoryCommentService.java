package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.HistoryComment;

import java.util.List;

public interface HistoryCommentService {
    List<HistoryComment> getAllHistoryComment();
    Page<HistoryComment> getHistoryComment(Integer pageSize, Integer page);
    HistoryComment getHistoryCommentById (Long id);
    Page<HistoryComment> getHistoryComments (Long studentId, Long advisorId, Pageable pageReq);
    HistoryComment save(HistoryComment comment);
}
