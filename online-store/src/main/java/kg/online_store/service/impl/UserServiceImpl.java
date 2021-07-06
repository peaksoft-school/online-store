package kg.online_store.service.impl;

import kg.online_store.model.User;
import kg.online_store.repository.UserRepository;
import kg.online_store.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User getUserByName(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.orElse(null);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
