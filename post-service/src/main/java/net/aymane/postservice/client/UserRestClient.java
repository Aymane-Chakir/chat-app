package net.aymane.postservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.aymane.postservice.external.User;
import net.aymane.postservice.external.UserResponseDto;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@FeignClient("USER-SERVICE")
public interface UserRestClient {
     //------------------------------- get user by id from userService -------------------------------------------------
@GetMapping("/api/user/{id}")
@CircuitBreaker(name = "userService", fallbackMethod = "getDefaultUser")
UserResponseDto getUser(@PathVariable Long id);
//-------------------------------- get all users from userService-------------------------------------------------------
@GetMapping("/api/users")
@CircuitBreaker(name = "userService", fallbackMethod = "getDefaultUsers")
     List<UserResponseDto> getAllUsers();

//---------------------------------- getDefault user si le service pris en charge---------------------------------------
     default UserResponseDto getDefaultUser(Long id, Exception exception){
          UserResponseDto user=new UserResponseDto();
          user.setId(id);
          user.setEmail("Not found");
          user.setFirstname("not found");
          user.setLastname("Not not found");
          return user;
     }

     default List<UserResponseDto> getDefaultUsers(Exception exception){
          return List.of();
     }
}
