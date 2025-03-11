package com.manudev.Trading.userService.mapper;

import com.manudev.Trading.userService.dto.UserDTO;
import com.manudev.Trading.userService.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    UserDTO userToDTO(User user);
    User dtoToUser(UserDTO userDTO);
}
