package miu.edu.wwalab1.service;

import miu.edu.wwalab1.model.Post;
import miu.edu.wwalab1.model.User;

import java.util.List;

public interface UserServiceInterface {
List<User> getAllUsers();
 User getUserById(Long id);
 void createUser(User user);
List <Post> getPostUser(Long id);


}
