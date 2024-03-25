package net.aymane.userservice.mapper;

import net.aymane.userservice.entity.User;
import net.aymane.userservice.model.UserRequestDto;
import net.aymane.userservice.model.UserResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public UserResponseDto fromEntityToDto(User user){
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user,userResponseDto);
        return userResponseDto;
    }


    public User fromReqToEntity(UserRequestDto userRequestDto){
        User user = new User();
        BeanUtils.copyProperties(userRequestDto,user);
        return user;
    }
}
