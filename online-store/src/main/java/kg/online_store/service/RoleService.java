package kg.online_store.service;

import kg.online_store.model.Role;

public interface RoleService {
    void addRole(Role role);
    void removeRoleById(long id);
}
