package miu.edu.wwalab1.controller;

import miu.edu.wwalab1.model.Post;
import miu.edu.wwalab1.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostServiceInterface postService;
    //a
    @GetMapping ("/")
    public List <Post> getAllPosts() {

        return postService.getAllPosts();
    }
    //b
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }
    //c
    @PostMapping("/createPost")
    public void createPost(@RequestBody Post post) {
        postService.save(post);
    }
    //d
    @DeleteMapping("/deletePostById/{id}")
    public void deletePostById(@PathVariable Long id) {
        postService.deleteById(id);
    }
    //e
    @PutMapping("/updatePost")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        postService.save(post);
    }


}
