package net.aymane.postservice;

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
	@Bean
	CommandLineRunner commandLineRunner (PostRepository postRepository){
		return args -> {
//			Post post = Post.builder()
//					.image("img1")
//					.caption("first pub")
//					.createdAt(new Date())
//					.build();
//			postRepository.save(post);
		};
	}

}
