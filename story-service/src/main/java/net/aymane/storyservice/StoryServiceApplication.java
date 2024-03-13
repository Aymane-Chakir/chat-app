package net.aymane.storyservice;

import lombok.AllArgsConstructor;
import net.aymane.storyservice.entity.Story;
import net.aymane.storyservice.repository.StoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class StoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(StoryRepository storyRepository){
		return args -> {
			Story story = Story.builder()
					.createdAt(new Date())
					.picture("src:1125")
					.build();
			storyRepository.save(story);
		};
	};
}
