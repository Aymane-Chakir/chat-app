package net.aymane.messageservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.aymane.messageservice.config.GlobalConfig;
import net.aymane.messageservice.entity.Message;
import net.aymane.messageservice.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
@EnableDiscoveryClient
@EnableConfigurationProperties({GlobalConfig.class})
@AllArgsConstructor
public class MessageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(MessageRepository messageRepository){
		return args -> {
			Message message = Message.builder()
					.content("hello dear")
					.createdAt(new Date())
					.build();
			messageRepository.save(message);

			Message message1 = Message.builder()
					.createdAt(new Date())
					.content("hello")
					.build();
			messageRepository.save(message1);
		};
			 };
}
