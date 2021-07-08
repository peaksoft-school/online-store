package kg.online_store.service;

import kg.online_store.model.Role;

public interface RoleService {
    void save(Role role);
    void deleteById(long id);
}
