package net.aymane.userservice.service;

import net.aymane.userservice.external.Pub;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    Pub createPub( String img, String content);
}
