package miu.edu.wwalabs.controller;

import miu.edu.wwalabs.model.Comment;
import miu.edu.wwalabs.service.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentServiceInterface commentService;
    @GetMapping
    public List<Comment> getComments() {
        return (List<Comment>) commentService.getAllComments();
    }
    @GetMapping("/{id}")
    public Comment getCommentById(Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping("create/{postId}")
    public void createComment(@RequestBody Comment comment, @PathVariable("postId") Long postId) {
        commentService.createComment(comment, postId);
    }
    @PostMapping("/{id}")
    public void updateComment(@PathVariable("id") Long id, Comment comment) {
        commentService.updateComment(id, comment);
    }
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.deleteComment(id);
    }



}
