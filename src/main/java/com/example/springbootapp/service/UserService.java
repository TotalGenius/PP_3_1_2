package com.example.springbootapp.service;


import com.example.springbootapp.entity.User;

import java.util.List;

public interface UserService {
    public User get(Long id);

    public List<User> getAll();

    public void save(User user);

    public void update(User user);

    public void delete(Long id);
}
