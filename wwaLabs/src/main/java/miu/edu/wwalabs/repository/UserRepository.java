package miu.edu.wwalabs.repository;

import miu.edu.wwalabs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from User u where u.posts.size> :n")
//    public  List<User> findUserByPostsGreaterThan(@Param("n") int n);
@Query("SELECT u FROM User u JOIN u.posts p GROUP BY u HAVING COUNT(p) > :n")
List<User> findByNumberOfPostsGreaterThan(@Param("n") int n);
}
