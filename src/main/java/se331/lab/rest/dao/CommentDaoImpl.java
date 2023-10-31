package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Comment;
import se331.lab.rest.repository.CommentRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentDaoImpl implements CommentDao{
    final CommentRepository commentRepository;

    @Override
    public Page<Comment> getComment(Pageable pageRequest) {
        return commentRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Page<Comment> getComments(String text, Pageable pageReq) {
        return commentRepository.findByTextContainingIgnoreCase(text, pageReq);
    }
}
