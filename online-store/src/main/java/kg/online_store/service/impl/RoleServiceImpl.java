package kg.online_store.service.impl;

import kg.online_store.model.Role;
import kg.online_store.repository.RoleRepository;
import kg.online_store.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void removeRoleById(long id) {
        roleRepository.deleteById(id);
    }
}
