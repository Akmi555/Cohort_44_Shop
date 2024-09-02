package de.ait_tr.shop.service;

import de.ait_tr.shop.model.dto.UserRegisterDto;
import de.ait_tr.shop.model.entity.User;
import de.ait_tr.shop.repository.UserRepository;
import de.ait_tr.shop.service.interfaces.EmailService;
import de.ait_tr.shop.service.interfaces.RoleService;
import de.ait_tr.shop.service.interfaces.UserService;
import de.ait_tr.shop.service.mapping.UserMappingService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2024
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final EmailService emailService;
    private final UserMappingService userMappingService;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleService roleService, EmailService emailService, UserMappingService userMappingService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.emailService = emailService;
        this.userMappingService = userMappingService;
    }

    @Transactional
    @Override
    public void register(UserRegisterDto registerDto) {
        User user = userMappingService.mapDtoToEntity(registerDto);

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        // Проверка, существует ли уже пользователь с таким email
        if (optionalUser.isPresent() && optionalUser.get().isActive()) {
            throw new RuntimeException("Email " + user.getEmail() + " already in use");
        }

        if (optionalUser.isPresent()) {
            // Пользователь в базе со статусов active - false
            user = optionalUser.get();
        } else {
            // Регистрация нового пользователь
            // Присваиваем роль User новому пользователю
            user.setRoles(Set.of(roleService.getRoleUser()));
        }

        //Устанавливаем зашифрованный пароль
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        // На всякий случай
        user.setActive(false);

        // Сохранить пользователя в БД
        userRepository.save(user);

        // Отправляем письмо с кодом подтверждения
        emailService.sendConfirmationEmail(user);

    }
}
