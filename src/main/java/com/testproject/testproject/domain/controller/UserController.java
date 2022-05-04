package com.testproject.testproject.domain.controller;

import com.testproject.testproject.domain.model.UserDto;
import com.testproject.testproject.domain.model.mapper.UserMapper;
import com.testproject.testproject.domain.service.UserService;
import com.testproject.testproject.persitence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private static final String GET_USERS_URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;
    private final UserService userService;

    @Autowired
    public UserController(RestTemplate restTemplate, UserService userService) {
        this.restTemplate = restTemplate;
        this.userService = userService;
    }

    @GetMapping(path = "/Users/save")
    public ResponseEntity saveUsers() {
        ResponseEntity<List<UserDto>> response = restTemplate.exchange(GET_USERS_URI, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<UserDto>>() {
                });

        List<User> userList = Objects.requireNonNull(response.getBody()).stream()
                .map(UserMapper::fromUserDtoToUser)
                .collect(Collectors.toList());

        userService.saveUsers(userList);

        return ResponseEntity.accepted().build();
    }
}
