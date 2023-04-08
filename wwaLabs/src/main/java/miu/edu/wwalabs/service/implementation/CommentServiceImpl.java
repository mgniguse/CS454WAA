package miu.edu.wwalabs.service.implementation;

import miu.edu.wwalabs.model.Comment;
import miu.edu.wwalabs.repository.CommentRepository;
import miu.edu.wwalabs.service.CommentServiceInterface;
import miu.edu.wwalabs.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentServiceInterface {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostServiceInterface postService;
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void createComment(Comment comment,Long postId) {
        var post= postService.getPostById(postId);
        post.getComments().add(comment);
        postService.save(post);
    //     commentRepository.save(comment);

    }

    @Override
    public List<Comment> getCommentPost(Long id) {
        Comment com = commentRepository.findById(id).orElse(null);
        if (com != null) {
            return com.getComments();
        }
        return null;
    }


    @Override
    public void updateComment(Long id, Comment comment) {
        Comment comm = commentRepository.findById(id).orElse(null);
        comm.setName(comment.getName());
        commentRepository.save(comm);
    }
    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);

    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

}
