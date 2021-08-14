package kg.online_store.service.impl;

import kg.online_store.model.Role;
import kg.online_store.repository.RoleRepository;
import kg.online_store.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByName(String name) {
        List<Role> roles = getRoles();
        return roles.stream().filter(r -> r.getName().equals(name)).findAny().orElse(null);
    }
}
