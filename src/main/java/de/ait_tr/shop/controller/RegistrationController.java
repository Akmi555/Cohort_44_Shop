package de.ait_tr.shop.controller;

import de.ait_tr.shop.exception_handling.Response;import de.ait_tr.shop.model.dto.UserRegisterDto;
import de.ait_tr.shop.service.interfaces.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sergey Bugaenko
 * {@code @date} 02.09.2024
 */

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Response registerUser(@RequestBody UserRegisterDto dto) {
        System.out.println(dto.toString());
        userService.register(dto);
        return new Response("Registration Complete. Please check your email");
    }




}
