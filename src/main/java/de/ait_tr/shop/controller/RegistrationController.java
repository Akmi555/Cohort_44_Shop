package de.ait_tr.shop.controller;

import de.ait_tr.shop.service.interfaces.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //TODO Контроллер
//    @PostMapping
//    public Response register(@RequestBody UserRegisterDto dto) {
//        //userService.register(userRegisterDto);
//        System.out.println(dto.toString());
//        return new Response("Registration Complete. Please check your email");
//    }
}
