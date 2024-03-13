package net.aymane.userservice.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.aymane.userservice.client.PostRestClient;
import net.aymane.userservice.external.Pub;
import net.aymane.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private PostRestClient postRestClient;
    @Override
    public Pub createPub(String img, String content) {
        return postRestClient.createPub(img, content);
    }
}
