package miu.edu.wwalabs.repository;

import jakarta.transaction.Transactional;
import miu.edu.wwalabs.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Transactional
    @Modifying
    @Query("update Comment c set c.id = ?1")
    void updateIdBy(long id);

}
