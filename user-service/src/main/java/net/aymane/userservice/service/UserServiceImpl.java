package net.aymane.userservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.aymane.userservice.entity.User;
import net.aymane.userservice.exception.UserException;
import net.aymane.userservice.mapper.UserMapper;
import net.aymane.userservice.model.UserRequestDto;
import net.aymane.userservice.model.UserResponseDto;
import net.aymane.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;
//------------------------------------------ add user ------------------------------------------------------------------
    @Override
    public UserResponseDto addUser(UserRequestDto user) {
        log.info("saving new user");
        User user1 = userMapper.fromReqToEntity(user) ;
        user1.setPassword(passwordEncoder.encode(user1.getPassword()));
        User user2 = userRepository.save(user1);
        return userMapper.fromEntityToDto(user2);
    }

//---------------------------- get user by id --------------------------------------------------------------------------
    @Override
    public UserResponseDto getUserById(Long id) throws UserException {
        User user = userRepository.findById(id).orElseThrow(()->new UserException("user not found"));
        return userMapper.fromEntityToDto(user);
    }
//------------------------------ get users list-------------------------------------------------------------------------
    @Override
    public List<UserResponseDto> allUsers() throws UserException {
        log.info("list of users");
        List<User> userList= userRepository.findAll();
        if (userList.isEmpty())throw new UserException("users not found");
        return userList.stream().map(userMapper::fromEntityToDto).collect(Collectors.toList());
    }
//----------------------------- delete user-----------------------------------------------------------------------------
    @Override
    public void deleteUser(Long id) throws UserException {
        log.info("user deleted!");
        User user = userRepository.findById(id).orElseThrow(()-> new UserException("user not found"));
        userRepository.delete(user);
    }

    // ------------------------------------ search by first name--------------------------------------------------------

    @Override
    public List<UserResponseDto> searchUser(String kw) throws UserException {
        List<User> userList = userRepository.findByFirstnameContains(kw);
        if (userList.isEmpty())throw new UserException("user not found");
        return userList.stream().map(userMapper::fromEntityToDto).toList();
    }
    //---------------------------- update user--------------------------------------------------------------------------

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) throws UserException {
        User user = userMapper.fromReqToEntity(userRequestDto);
        User user1 =userRepository.findById(user.getId()).orElseThrow(()-> new UserException("user not found"));
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setEmail(user.getEmail());
        user1.setBio(user.getBio());
        user1.setPicture(user.getPicture());
        User updated = userRepository.save(user1);
        return userMapper.fromEntityToDto(updated);
    }
}
