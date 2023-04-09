package miu.edu.wwalabs.controller;

import miu.edu.wwalabs.aspect.annotation.ExecutionTime;
import miu.edu.wwalabs.model.Post;
import miu.edu.wwalabs.model.User;
import miu.edu.wwalabs.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceInterface userService;


    // a, get all users
  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }
  //b get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    //c get all posts of a user
    @PostMapping
    public void creatNewUser(@RequestBody User user) {
        userService.createUser(user);
    }
        //d get all posts of a user
    @GetMapping("/{id}/posts")
    public List<Post> getPostUser(@PathVariable Long id) {
        return userService.getPostUser(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        User user = userService.findById(id);
        userService.deleteByUser(user);
        userService.delete(user);
    }
    @GetMapping("/posts/{n}")
    public List<User> findUserByPostsGreaterThan(@PathVariable int n) {
        return userService.findByNumberOfPostsGreaterThan(n);
    }
    @ExecutionTime
    @GetMapping("/execute/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.findById(id);
    }







}
