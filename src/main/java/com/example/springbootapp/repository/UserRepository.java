package com.example.springbootapp.repository;


import com.example.springbootapp.entity.User;

import java.util.List;

public interface UserRepository {
    public User get(Long id);

    public List<User> getAll();

    public void save(User user);

    public void update(User user);

    public void delete(Long id);
}
