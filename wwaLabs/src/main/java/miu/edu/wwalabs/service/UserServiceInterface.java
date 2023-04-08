package miu.edu.wwalabs.service;

import miu.edu.wwalabs.model.Post;
import miu.edu.wwalabs.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserServiceInterface {
List<User> getAllUsers();
 User getUserById(Long id);
 void createUser(User user);
List <Post> getPostUser(Long id);
List<User> findUserByPostsGreaterThan(@Param("n") int n);


 void deleteByUser(User user);

 User findById(long id);

 void delete(User user);
 public List<User> findByNumberOfPostsGreaterThan(int n);
}
