package com.example.diaryapp.service;


import com.example.diaryapp.dto.UserDTO;
import com.example.diaryapp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(UserDTO userDTO);
    User updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}

