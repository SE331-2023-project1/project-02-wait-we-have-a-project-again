package se331.lab.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.CommentDao;
import se331.lab.rest.entity.Comment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    final CommentDao commentDao;
    @Override
    public List<Comment> getAllComment() {
        return commentDao.getComment(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Comment> getComment(Integer pageSize, Integer page) {
        return commentDao.getComment(PageRequest.of(pageSize, page));
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentDao.findById(id).orElse(null);
    }

    @Override
    public Page<Comment> getComments(String text, Pageable pageReq) {
        return commentDao.getComments(text, pageReq);
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }
}
