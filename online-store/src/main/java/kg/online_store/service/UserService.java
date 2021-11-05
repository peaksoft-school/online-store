package kg.online_store.service;

import kg.online_store.model.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    boolean verify(String verificationCode);
    List<User> findAll();
    User findById(long id);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    void insert(User user,String siteURL) throws UnsupportedEncodingException, MessagingException;
    void deleteById(long id);
    void save(User user);
}
