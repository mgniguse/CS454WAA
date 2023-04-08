package miu.edu.wwalabs.service;

import miu.edu.wwalabs.model.Comment;

import java.util.List;

public interface CommentServiceInterface {
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    void createComment(Comment comment, Long postId);
    List<Comment> getCommentPost(Long id);


    void updateComment(Long id, Comment comment);

    void deleteComment(Long id);

    void save(Comment comment);


}
