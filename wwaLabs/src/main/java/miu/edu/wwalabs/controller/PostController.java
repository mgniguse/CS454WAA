package miu.edu.wwalabs.controller;

import miu.edu.wwalabs.model.Comment;
import miu.edu.wwalabs.model.Post;
import miu.edu.wwalabs.service.PostServiceInterface;
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
    @PutMapping("/updatePost/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        postService.save(post);
    }

    @PostMapping("/{id}/comments")
    public void addCommentToPost(@PathVariable Long id, @RequestBody Comment comment) {
        Post post = (Post) postService.getCommentById(id);
        post.getComments().add(comment);
        postService.save(post);
    }
    @GetMapping("/search")
    public List<Post> searchPostsByTitle(@RequestParam String title) {
        return postService.findByTitleContaining(title);
    }

}
