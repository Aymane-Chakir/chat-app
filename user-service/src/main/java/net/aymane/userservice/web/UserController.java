package net.aymane.userservice.web;

import lombok.AllArgsConstructor;

import net.aymane.userservice.exception.UserException;

import net.aymane.userservice.model.UserRequestDto;
import net.aymane.userservice.model.UserResponseDto;
import net.aymane.userservice.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private UserService userService;

//-------------------------------- get user ----------------------------------------------------------------------------
    @GetMapping("/user/{id}")
public  ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) throws UserException {
        UserResponseDto responseDto = userService.getUserById(id);
//        Map<String,Object> reponse = new HashMap<>();
//        reponse.put("status","201");
//        reponse.put("data",responseDto);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
}

    // ------------------------------ get user list---------------------------------------------------------------------
    @GetMapping("/users")
    public  ResponseEntity<?> getAllUsers() throws UserException {
        List<UserResponseDto> responseDtoList = userService.allUsers();
        Map<String,Object> response = new HashMap<>();
        response.put("status","201");
        response.put("data",responseDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // ---------------------------------- add user----------------------------------------------------------------------
@PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto= userService.addUser(userRequestDto);
        Map<String,Object> response= new HashMap<>();
        response.put("status","201");
        response.put("data",userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    //------------------------------------- update user ---------------------------------------------------------------
@PutMapping("/user/{id}")
public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) throws UserException {
       userRequestDto.setId(id);
       UserResponseDto responseDto = userService.updateUser(userRequestDto);
        Map<String,Object> response = new HashMap<>();
        response.put("status","201");
        response.put("data",responseDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
}

    //------------------------------ delete user -----------------------------------------------------------------------
@DeleteMapping("/user/{id}")
public ResponseEntity<?> deleteUser(@PathVariable Long id) throws UserException {
userService.deleteUser(id);
Map<String,String> response= new HashMap<>();
response.put("status","201");
response.put("message","user deleted successfully");
return ResponseEntity.status(HttpStatus.OK).body(response);
}
 //----------------------------------  search user by his firstName -----------------
@GetMapping("/user/search")
public  ResponseEntity<?> searchUser(@RequestParam("kw") String kw) throws UserException {
        List<UserResponseDto> responseDtoList = userService.searchUser(kw);
        Map<String,Object> response = new HashMap<>();
        response.put("status","201");
        response.put("data",responseDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
}



}
