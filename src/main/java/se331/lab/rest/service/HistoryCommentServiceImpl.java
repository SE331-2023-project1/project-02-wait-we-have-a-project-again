package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.HistoryCommentDao;
import se331.lab.rest.entity.HistoryComment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryCommentServiceImpl implements HistoryCommentService{
    final HistoryCommentDao historyCommentDao;
    @Override
    public List<HistoryComment> getAllHistoryComment() {
        return null;
    }

    @Override
    public Page<HistoryComment> getHistoryComment(Integer pageSize, Integer page) {
        return null;
    }

    @Override
    public HistoryComment getHistoryCommentById(Long id) {
        return null;
    }

    @Override
    public Page<HistoryComment> getHistoryComments(Long studentId, Long advisorId, Pageable pageReq) {
        return null;
    }

    @Override
    public HistoryComment save(HistoryComment comment) {
        return null;
    }
}
