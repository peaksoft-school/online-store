package kg.online_store.service;

import kg.online_store.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    void save(User user);
    void deleteById(long id);
    List<User>findPaginated(int pageNo,int pageSize);
}
