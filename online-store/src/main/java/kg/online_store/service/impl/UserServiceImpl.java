package kg.online_store.service.impl;

import kg.online_store.model.User;
import kg.online_store.repository.UserRepository;
import kg.online_store.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        return user.orElse(null);
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.orElse(null);
    }

    @Override
    public void save(User user) {
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
