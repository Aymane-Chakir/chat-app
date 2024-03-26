package net.aymane.userservice;

import lombok.AllArgsConstructor;
//import net.aymane.userservice.config.GlobalConfig;
import net.aymane.userservice.config.GlobalConfig;
import net.aymane.userservice.entity.User;
import net.aymane.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication

@EnableDiscoveryClient
@EnableConfigurationProperties({GlobalConfig.class})
@AllArgsConstructor
public class UserServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {

			User user = User.builder()
					.email("aymane.kk@gmail.net")
					.password("123456")
					.lastname("ch")
					.phoneNumber("0628992567")
					.firstname("aymane")
					.createdAt(new Date())
					.build();
				userRepository.save(user);

		};


	}

@Bean
	public PasswordEncoder passwordEncoder(){
		return  new BCryptPasswordEncoder();
	}

}


