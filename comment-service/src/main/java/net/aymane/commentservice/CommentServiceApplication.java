package net.aymane.commentservice;

import net.aymane.commentservice.entity.Comment;
import net.aymane.commentservice.repository.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CommentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CommentRepository commentRepository){
	return args -> {
		Comment comment = Comment.builder()
				.content("nice pic bro")
				.createdAt(new Date())
				.build();
		commentRepository.save(comment);
	};
	};

}
