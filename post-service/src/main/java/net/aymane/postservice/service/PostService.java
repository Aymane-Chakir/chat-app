package net.aymane.postservice.service;

import net.aymane.postservice.entity.Post;
import net.aymane.postservice.exception.PostNotFoundException;

public interface PostService {
    Post createPub(String img, String caption);
    Post getPub(Long id) throws PostNotFoundException;


}
