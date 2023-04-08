package miu.edu.wwalabs.service.implementation;

import miu.edu.wwalabs.model.Post;
import miu.edu.wwalabs.model.User;
import miu.edu.wwalabs.repository.UserRepository;
import miu.edu.wwalabs.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceInterface {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);

    }

    @Override
    public List <Post> getPostUser(Long id) {
        User u = userRepository.findById(id).orElse(null);

        if (u != null) {
            return u.getPosts();
        }

        return null;
    }

    @Override
    public List<User> findUserByPostsGreaterThan(int n) {
//        return userRepository.findUserByPostsGreaterThan(n);
        return userRepository.findUsersWithMoreThanNPosts(n);
    }


    @Override
    public void deleteByUser(User user) {

    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> findByNumberOfPostsGreaterThan(int n) {
        return null;
    }

//    @Override
//    public void delete(User user){
//        UserRepository.delete(user);
//    }


}
