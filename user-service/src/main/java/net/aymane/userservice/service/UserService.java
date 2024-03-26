package net.aymane.userservice.service;


import net.aymane.userservice.entity.User;
import net.aymane.userservice.exception.UserException;
import net.aymane.userservice.external.Pub;
import net.aymane.userservice.model.UserRequestDto;
import net.aymane.userservice.model.UserResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
//    Pub createPub( String img, String content, Long id);
//    Pub getPubById(Long id);


    // ----------------------- add user --------------------------------------------------------------------------------

   public UserResponseDto addUser(UserRequestDto user);

    //----------------------- update user-------------------------------------------------------------------------------
   public UserResponseDto updateUser( UserRequestDto userRequestDto) throws UserException;


    //------------------------ get user by id---------------------------------------------------------------------------

   public UserResponseDto getUserById(Long id) throws UserException;

    //------------------------------- get all users---------------------------------------------------------------------
   public List<UserResponseDto> allUsers() throws UserException;
   // ---------------------------------- delete user--------------------------------------------------------------------
   public void deleteUser(Long id) throws UserException;
   //--------------------------------- search by name ------------------------------------------------------------------

    public List<UserResponseDto> searchUser(String kw) throws UserException;



}
