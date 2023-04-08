package miu.edu.wwalabs.service.implementation;

import miu.edu.wwalabs.model.Comment;
import miu.edu.wwalabs.model.Post;
import miu.edu.wwalabs.model.User;
import miu.edu.wwalabs.repository.PostRepository;
import miu.edu.wwalabs.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostServiceInterface {
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

    @Override
    public List<Comment> getCommentById(Long id) {
        Post p = postRepository.findById(id).orElse(null);
        return p.getComments();
    }

    @Override
    public List<Post> findByTitleContaining(String title) {
        return postRepository.findByTitleContaining(title);
    }
    @Override
    public void update(Post post, Long id) {
        Post p=postRepository.findById(id).get();
        p.setAuthor(post.getAuthor());
        p.setContent(post.getContent());
        p.setTitle(post.getTitle());
        postRepository.save(p);
    }
    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }
    @Override
    public void deleteByUser(User user) {
        //List<Post> posts = postRepository.findByUser(user);
//        for (Post p : posts) {
//          //  postRepository.delete(p);
//        }
    }


}
