package kg.online_store.service;

import kg.online_store.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void deleteById(long id);
    List<Role> getRoles();
    Role getRoleByName(String name);
}
