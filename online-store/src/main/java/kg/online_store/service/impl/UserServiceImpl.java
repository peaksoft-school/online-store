package kg.online_store.service.impl;

import kg.online_store.model.Role;
import kg.online_store.model.User;
import kg.online_store.repository.UserRepository;
import kg.online_store.service.RoleService;
import kg.online_store.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;

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

    /**
     * Роль юзера назначаеться автоматически всем новым пользователям.
     * @param user
     */
    @Override
    public void save(User user) {
        String encryptedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPass);
//        Set<Role> rolesFromBD = new HashSet<>();
//        rolesFromBD.add(roleService.getRoleByName("ROLE_USER"));
//        user.setRoles(rolesFromBD);
//        user.setRegisterDate(LocalDate.now());
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findPaginated(int pageNo, int pageSize) {
        Pageable paging= PageRequest.of(pageNo, pageSize) ;
        Page<User> pagedResult = userRepository.findAll(paging);
        return pagedResult.toList();
    }
}
