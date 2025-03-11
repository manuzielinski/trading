package com.manudev.Trading.userService.service.impl;

import com.manudev.Trading.userService.dto.UserDTO;
import com.manudev.Trading.userService.mapper.UserMapper;
import com.manudev.Trading.userService.model.User;
import com.manudev.Trading.userService.repository.UserRepository;
import com.manudev.Trading.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> listAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByID(Long userID) {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return userMapper.userToDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.dtoToUser(userDTO);
        userRepository.save(user);
        return userMapper.userToDTO(user);
    }

    @Override
    public UserDTO updateUser(Long userID, UserDTO userDTO) {
        // first, we're going to find the old user:
        User oldUser = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        // later, locate the new one
        User updatedUser = userMapper.dtoToUser(userDTO);
        updatedUser.setUserID(oldUser.getUserID());
        return userMapper.userToDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userID) {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        user.setActive(false);
        userRepository.save(user);
    }
}
