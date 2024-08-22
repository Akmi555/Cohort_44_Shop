package de.ait_tr.shop.security.dto;

import java.util.Objects;

/**
 * @author Sergey Bugaenko
 * {@code @date} 22.08.2024
 */

public class RefreshRequestDto {
    private String refreshToken;


    @Override
    public String toString() {
        return "Refresh request: refresh token: " + refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RefreshRequestDto that = (RefreshRequestDto) o;
        return Objects.equals(refreshToken, that.refreshToken);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(refreshToken);
    }
}
