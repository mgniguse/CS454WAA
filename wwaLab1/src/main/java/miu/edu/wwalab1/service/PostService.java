package miu.edu.wwalab1.service;

import miu.edu.wwalab1.model.Post;
import miu.edu.wwalab1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface{
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post addPost(Post post) {
        return null;
    }

    public Post save(Post post) {
        postRepository.save(post);
    return post;
}
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
    public void update(Post post) {
        postRepository.save(post);
    }

}
