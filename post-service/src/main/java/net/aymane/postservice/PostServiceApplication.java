package net.aymane.postservice;

import net.aymane.postservice.client.UserRestClient;
import net.aymane.postservice.config.GlobalConfig;
import net.aymane.postservice.entity.Post;
import net.aymane.postservice.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(GlobalConfig.class)
@RefreshScope
public class PostServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostServiceApplication.class, args);
	}
//	@Bean
//	CommandLineRunner commandLineRunner (PostRepository postRepository, UserRestClient userRestClient){
//		return args -> {
//			userRestClient.getAllUsers().forEach(user -> {
//				Post post = Post.builder()
//						.createdAt(new Date())
//						.image("nft22")
//						.User_id(user.getId())
//						.build();
//
//				Post post1 = Post.builder()
//						.caption("nft sus")
//						.image("ghjkl")
//						.User_id(user.getId())
//						.createdAt(new Date())
//						.build();
//				postRepository.save(post);
//				postRepository.save(post1);
//			});
//		   };
//		};
	}


