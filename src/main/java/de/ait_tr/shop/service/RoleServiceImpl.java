package de.ait_tr.shop.service;

import de.ait_tr.shop.model.entity.Role;
import de.ait_tr.shop.repository.RoleRepository;
import de.ait_tr.shop.service.interfaces.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Bugaenko
 * {@code @date} 30.08.2024
 */

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleUser() {
        // Получаем роль USER из базы данных
        return roleRepository.findByTitle("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Database doesn't contain ROLE_USER"));
    }
}
