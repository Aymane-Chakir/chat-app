package net.aymane.postservice.service;

import net.aymane.postservice.exception.PostNotFoundException;
import net.aymane.postservice.external.CommentDto;
import net.aymane.postservice.external.UserResponseDto;
import net.aymane.postservice.model.PostRequestDto;
import net.aymane.postservice.model.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostService {
//    Post createPub(Post post);


   //---------------------------------- get publication by id ----------------------------------------------------------
   public PostResponseDto getPub(Long id) throws PostNotFoundException;

   // ------------------------------------ create post------------------------------------------------------------------
   public PostResponseDto createPost (PostRequestDto requestDto);

   //----------------------------------- update post--------------------------------------------------------------------
   public PostResponseDto updatePost( PostRequestDto postRequestDto) throws PostNotFoundException;

   //------------------------------------- get all posts----------------------------------------------------------------
   public List<PostResponseDto> allPosts() throws PostNotFoundException;


   //------------------------------------------ search for publication--------------------------------------------------

   public List<PostResponseDto> searchPost(String kw) throws PostNotFoundException;

//---------------------------------------------- add like --------------------------------------------------------------
   public void like(Long id) throws PostNotFoundException;


   //------------------------------- delete post------------------------------------------------------------------------
   public void deletePost(Long id) throws PostNotFoundException;
   //--------------------------------- add comment to publication-------------------------------------------------------
   public CommentDto addCommentToPublication(CommentDto commentDto);

   //-------------------------------------- get user by id from user service-------------------------------------------
      public UserResponseDto getUser(Long id);
}
