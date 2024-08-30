package de.ait_tr.shop.service.interfaces;

import de.ait_tr.shop.model.entity.User;

/**
 * @author Sergey Bugaenko
 * {@code @date} 30.08.2024
 */

public interface EmailService {
    //Метод для отправки email пользователю
    void sendConfirmationEmail(User user);
}
