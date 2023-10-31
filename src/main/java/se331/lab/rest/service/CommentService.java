package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment();
    Page<Comment> getComment(Integer pageSize, Integer page);
    Comment getCommentById (Long id);
    Page<Comment> getComments (String author, Pageable pageReq);
    Comment save(Comment comment);
}
