package de.ait_tr.shop.security.dto;

import java.util.Objects;

/**
 * @author Sergey Bugaenko
 * {@code @date} 22.08.2024
 */

public record LoginRequestDto(String username, String password) {

}
