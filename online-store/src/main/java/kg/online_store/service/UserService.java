package kg.online_store.service;

import kg.online_store.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    void addUser(User user);
    void deleteById(long id);
    void save(User user);
}
