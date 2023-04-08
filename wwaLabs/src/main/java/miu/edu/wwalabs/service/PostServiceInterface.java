package miu.edu.wwalabs.service;

import miu.edu.wwalabs.model.Comment;
import miu.edu.wwalabs.model.Post;
import miu.edu.wwalabs.model.User;

import java.util.List;

public interface PostServiceInterface {

    Post addPost(Post post);
    Post save(Post post);
    Post getPostById(Long id);

    List<Post> getAllPosts();

    void deleteById(Long id);

    List<Comment> getCommentById(Long id);

    List<Post> findByTitleContaining(String title);

    void update(Post post, Long id);

    void delete(Post post);

    void deleteByUser(User user);
}

