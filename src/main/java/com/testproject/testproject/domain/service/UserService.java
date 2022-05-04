package com.testproject.testproject.domain.service;

import com.testproject.testproject.persitence.model.User;
import com.testproject.testproject.persitence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUsers(List<User> users) {
        userRepository.saveAll(users);
    }
}
