package se331.lab.rest.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Comment;
import org.springframework.data.domain.Page;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAll() ;
    Page<Comment> findByTextContainingIgnoreCase (String text, Pageable pageReq);
}
