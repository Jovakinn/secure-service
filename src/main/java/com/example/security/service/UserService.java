package com.example.security.service;


import com.example.security.domain.Role;
import com.example.security.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    // not for production use
    List<User> getUsers();
}
