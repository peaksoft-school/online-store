package kg.online_store.service;

import kg.online_store.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(long id);
    User getUserByName(String username);
    User getUserByEmail(String email);
    void addUser(User user);
    void deleteUserById(long id);
}
