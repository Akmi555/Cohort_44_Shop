package de.ait_tr.shop.service.interfaces;

import de.ait_tr.shop.model.dto.UserRegisterDto;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2024
 */

public interface UserService {

    void register(UserRegisterDto registerDto);
    String confirmationMailByCode(String code);
}
