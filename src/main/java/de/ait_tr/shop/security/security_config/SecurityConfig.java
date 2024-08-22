package de.ait_tr.shop.security.security_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Sergey Bugaenko
 * {@code @date} 22.08.2024
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) // настройка сессий
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/products").permitAll() // разрешено всем
                        .requestMatchers(HttpMethod.GET, "/products/{id}").authenticated() //  только для аутентифицированных пользователей
//                        .requestMatchers(HttpMethod.GET, "/products/{id}").hasAnyRole("ADMIN", "USER") //  только для пользователей с ролью USER или ADMIN
                       .requestMatchers(HttpMethod.POST, "/products").hasRole("ADMIN")
                );

       return http.build();
    }




    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

/*
Уровни доступа!
1. Получение всех продуктов - доступно всем пользователям, включая анонимных (аутентификация не требуется)
2. Получение продукта по id - доступно только аутентифицированным пользователям с любой ролью
3. Сохранение нового продукта - доступно только администраторам. (аутентифицирован + имеет роль ADMIN)
 */