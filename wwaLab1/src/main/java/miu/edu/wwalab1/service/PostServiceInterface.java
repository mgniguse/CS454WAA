package miu.edu.wwalab1.service;

import miu.edu.wwalab1.model.Post;

import java.util.List;

public interface PostServiceInterface {

    Post addPost(Post post);
    Post save(Post post);
    Post getPostById(Long id);

    List<Post> getAllPosts();

    void deleteById(Long id);
}

