package com.example.springbootapp.service.impl;

import com.example.springbootapp.entity.User;
import com.example.springbootapp.repository.UserRepository;
import com.example.springbootapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(Long id) {
        return userRepository.get(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
