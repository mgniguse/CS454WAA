package miu.edu.wwalab1.service;

import miu.edu.wwalab1.model.Post;
import miu.edu.wwalab1.model.User;
import miu.edu.wwalab1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{
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

}
