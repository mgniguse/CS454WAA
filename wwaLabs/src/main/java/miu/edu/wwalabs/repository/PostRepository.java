package miu.edu.wwalabs.repository;

import miu.edu.wwalabs.model.Post;
import miu.edu.wwalabs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("select p from Post p where p.title= : title")
    public List<Post> findByTitleContainingIgnoreCase( String title);

//    public List<Post> findByUser(User user);

    public List<Post> findByTitleContaining(String title);
}
