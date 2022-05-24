package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("one-ud-1")
    public String test() {
        User user = new User();
        user.setFirstName("Alex");

        Address address = new Address();
        address.setStreet("Koneva");

        user.setAddress(address);

        userRepository.persist(user);
        return "OK";
    }
}
