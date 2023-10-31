package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.HistoryComment;
import se331.lab.rest.repository.HistoryCommentRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HistoryCommentDaoImpl implements HistoryCommentDao{
    final HistoryCommentRepository commentHistoryRepository;
    @Override
    public Page<HistoryComment> getHistoryComment(Pageable pageRequest) {
        return commentHistoryRepository.findAll(pageRequest);
    }
    @Override
    public Optional<HistoryComment> findById(Long id) {
        return commentHistoryRepository.findById(id);
    }
    @Override
    public HistoryComment save(HistoryComment commentHistory) {
        return commentHistoryRepository.save(commentHistory);
    }
    @Override
    public Page<HistoryComment> getHistoryComments(Long studentId, Long AdvisorId, Pageable pageReq) {
        return commentHistoryRepository.findByStudentIdContainingOrAdvisorId(studentId, AdvisorId, pageReq);
    }
}
