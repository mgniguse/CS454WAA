package miu.edu.wwalab1.controller;

import miu.edu.wwalab1.model.Post;
import miu.edu.wwalab1.model.User;
import miu.edu.wwalab1.service.UserServiceInterface;
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







}
