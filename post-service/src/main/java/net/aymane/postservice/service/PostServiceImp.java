package net.aymane.postservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.aymane.postservice.client.CommentServiceClient;
import net.aymane.postservice.client.UserRestClient;
import net.aymane.postservice.entity.Post;
import net.aymane.postservice.exception.PostNotFoundException;
import net.aymane.postservice.external.CommentDto;
import net.aymane.postservice.external.UserResponseDto;
import net.aymane.postservice.mapper.PostMapper;
import net.aymane.postservice.model.PostRequestDto;
import net.aymane.postservice.model.PostResponseDto;
import net.aymane.postservice.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PostServiceImp implements PostService{
    private final PostRepository postRepository;
    private final UserRestClient userRestClient;
    private CommentServiceClient commentServiceClient;
    private final PostMapper postMapper;


//-------------------------------------- get publication by Id ---------------------------------------------------------
    @Override
    public PostResponseDto getPub(Long id) throws PostNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(()->new PostNotFoundException("post not found "));
//       UserResponseDto user = getUser(post.getUser_id());
        return postMapper.fromEntityToDto(post);
    }
// --------------------------------------- add publication--------------------------------------------------------------
    @Override
    public PostResponseDto createPost(PostRequestDto requestDto) {
        UserResponseDto userResponseDto= getUser(requestDto.getUser_id());
        System.out.println(userResponseDto);
        Post post = postMapper.fromRequestDtoToEntity(requestDto);
        post.setUserResponseDto(userResponseDto);
        Post post1= postRepository.save(post);
        return postMapper.fromEntityToDto(post1);
    }
    //------------------------------------------- update publication----------------------------------------------------
    @Override
    public PostResponseDto updatePost(PostRequestDto postRequestDto) throws PostNotFoundException {
        Post post =postMapper.fromRequestDtoToEntity(postRequestDto);
        Post post1 =postRepository.findById(post.getId()).orElseThrow(()->new PostNotFoundException("publication not found"));
        post1.setActive(post.getActive());
        post1.setCaption(post.getCaption());
        post1.setImage(post.getImage());
        Post updated = postRepository.save(post1);
        return postMapper.fromEntityToDto(updated);
    }
//-------------------------------- get all publications-----------------------------------------------------------------
    @Override
    public List<PostResponseDto> allPosts() throws PostNotFoundException {
        List<Post> postList = postRepository.findAll();
        if (postList.isEmpty())throw new PostNotFoundException("not found :(");
        return postList.stream().map(postMapper::fromEntityToDto).collect(Collectors.toList());
    }
//----------------------------------- search for an publication---------------------------------------------------------
    @Override
    public List<PostResponseDto> searchPost(String kw) throws PostNotFoundException {
        List<Post> postList = postRepository.findByCaptionContains(kw);
        if (postList.isEmpty())throw new PostNotFoundException("publication not found");
        return postList.stream().map(postMapper::fromEntityToDto).collect(Collectors.toList());
    }
//------------------------------------ add like ------------------------------------------------------------------------
    @Override
    public void like(Long id) throws PostNotFoundException {
        Post post = postRepository.findById(id).orElseThrow(()->new PostNotFoundException("not found"));
        post.setActive(true);
        }
//------------------------------------- delete publication--------------------------------------------------------------
    @Override
    public void deletePost(Long id) throws PostNotFoundException {
        log.info("post deleted");
        Post post = postRepository.findById(id).orElseThrow(()->new PostNotFoundException("impossible "));
        postRepository.delete(post);
    }


    // --------------------------------- add comment to publication-----------------------------------------------------
    @Override
    public void addCommentToPublication(CommentDto commentDto) {
        commentServiceClient.addComment(commentDto);
    }
//--------------------------------------- get user from userService-----------------------------------------------------
    @Override
    public UserResponseDto getUser(Long id) {
        return userRestClient.getUser(id).getBody();
    }
}



